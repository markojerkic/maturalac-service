package com.maturalac.maturalacservice.data;

import com.maturalac.maturalacservice.data.entity.*;
import com.maturalac.maturalacservice.data.entity.util.AnswerType;
import com.maturalac.maturalacservice.data.entity.util.FileType;
import com.maturalac.maturalacservice.data.repository.QuestionRepository;
import com.maturalac.maturalacservice.data.repository.SavedFileRepository;
import com.maturalac.maturalacservice.data.repository.SubjectYearRelationRepository;
import com.maturalac.maturalacservice.data.repository.SuperQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RepositoryTests {
    @Autowired
    private SavedFileRepository savedFileRepository;
    @Autowired
    private SuperQuestionRepository superQuestionRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SubjectYearRelationRepository subjectYearRelationRepository;

    @Test
    public void testFilesDBStorage() {
        SavedFile s = new SavedFile();
        s.setFileName("testni");
        s.setFileType(FileType.IMAGE);

        SavedFile sf = this.savedFileRepository.save(s);
        log.info(sf.toString());
        Assertions.assertEquals(s.getFileType(), sf.getFileType());

        SavedFile byFileType = this.savedFileRepository.findByFileType(FileType.IMAGE);
        Assertions.assertEquals(byFileType, sf);
    }

    @Test
    @Sql(scripts = "/files_from_string.sql")
    public void testFilesByString() {
        FileType ft = FileType.IMAGE;
        log.info(this.savedFileRepository.findAll().toString());
        Assertions.assertEquals(3, this.savedFileRepository.findAllByFileType(ft).size());
    }

    @Test
    public void testSuperQuestion() {
        SuperQuestion sq = new SuperQuestion();
        sq.setQuestion("neko pitanje");
        SuperQuestion savedSq = this.superQuestionRepository.save(sq);

        Assertions.assertNull(savedSq.getAudio());
        Assertions.assertNull(savedSq.getImage());

        SuperQuestion sqWithImage = new SuperQuestion();
        SavedFile image = new SavedFile();
        image.setFileType(FileType.IMAGE);
        image.setFileName("slika");
        sqWithImage.setImage(image);

        SuperQuestion savedSqWithImage = this.superQuestionRepository.save(sqWithImage);

        Assertions.assertEquals(image.getFileName(), savedSqWithImage.getImage().getFileName());
        Assertions.assertNull(savedSqWithImage.getAudio());
    }

    @Test
    public void testQuestion() {
        SuperQuestion sq = new SuperQuestion();
        sq.setQuestion("neko ptianje");

        Question q = new Question();
        q.setQuestion("neko pitanje");
        q.setAnswerType(AnswerType.ABCD);
        q.setCorrectAnswer(0);
        q.setSuperQuestion(sq);

        Question savedQ = this.questionRepository.save(q);

        SuperQuestion savedSq = savedQ.getSuperQuestion();

        Question q1 = new Question();
        q1.setQuestion("neko pitanje");
        q1.setAnswerType(AnswerType.ABCD);
        q1.setCorrectAnswer(0);
        SuperQuestion sqWithIdOnly = new SuperQuestion();
        sqWithIdOnly.setId(savedSq.getId());
        q1.setSuperQuestion(sq);

        Question savedQ2 = this.questionRepository.save(q1);

        Assertions.assertEquals(savedSq, savedQ2.getSuperQuestion());
    }

    @Test
    public void testSubjectYearRelationRepository() {
        Subject s = new Subject();
        s.setSubjectName("Matematika");
        ExamYear ey = new ExamYear();
        ey.setExamName("2021. zima");

        SubjectYearRelation syr = new SubjectYearRelation();
        syr.setExamYear(ey);
        syr.setSubject(s);

        SubjectYearRelation savedSyr = this.subjectYearRelationRepository.save(syr);

        Assertions.assertNotNull(savedSyr);

        List<SubjectYearRelation> found = this.subjectYearRelationRepository
                .findAllBySubject(savedSyr.getSubject());
        assertTrue(found.stream().map(SubjectYearRelation::getSubject)
                .map(Subject::getSubjectName).anyMatch(sn -> sn.equals(s.getSubjectName())));
        assertTrue(found.stream().map(SubjectYearRelation::getExamYear)
                .map(ExamYear::getExamName).anyMatch(en -> en.equals(ey.getExamName())));
    }

    @Test
    @Sql(scripts = "/by_subject_and_public.sql")
    public void testFindAllBySubjectAndAndIsPublic() {
        Subject subject = new Subject();
        subject.setId(1L);
        List<SubjectYearRelation> found = this.subjectYearRelationRepository.findAllBySubjectAndAndIsPublic(subject, true);
        found.forEach(syr -> {
            assertTrue(syr.isPublic());
            assertEquals(1L, syr.getSubject().getId());
        });
    }

}
