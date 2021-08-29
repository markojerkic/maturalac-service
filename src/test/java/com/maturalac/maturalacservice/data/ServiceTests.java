package com.maturalac.maturalacservice.data;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.service.SubjectYearRelationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class ServiceTests {

    @Autowired
    private SubjectYearRelationService subjectYearRelationService;

    @Test
    public void testRepository() {
        Subject s = new Subject();
        s.setSubjectName("Matematika");
        ExamYear ey = new ExamYear();
        ey.setExamName("2021. zima");

        SubjectYearRelation syr = new SubjectYearRelation();
        syr.setExamYear(ey);
        syr.setSubject(s);

        SubjectYearRelation savedSyr = this.subjectYearRelationService.saveSubjectYearRelation(syr);

        Assertions.assertNotNull(savedSyr);

        List<SubjectYearRelation> found = this.subjectYearRelationService
                .getAllBySubject(savedSyr.getSubject());
        Assertions.assertTrue(found.stream().map(SubjectYearRelation::getSubject)
                .map(Subject::getSubjectName).anyMatch(sn -> sn.equals(s.getSubjectName())));
        Assertions.assertTrue(found.stream().map(SubjectYearRelation::getExamYear)
                .map(ExamYear::getExamName).anyMatch(en -> en.equals(ey.getExamName())));
    }

    @Test
    public void testSubjectYearRelationPublish() {
        SubjectYearRelation syr = new SubjectYearRelation();
        Subject sub = new Subject();
        sub.setSubjectName("jkl");
        ExamYear ey = new ExamYear();
        ey.setExamName("iop");
        syr.setSubject(sub);
        syr.setExamYear(ey);

        syr = this.subjectYearRelationService.saveSubjectYearRelation(syr);

        Assertions.assertEquals(false, syr.isPublic());

        SubjectYearRelation syr1 = new SubjectYearRelation();
        syr1.setId(syr.getId());
        syr = this.subjectYearRelationService.publishSubjectYearRelation(syr1);

        Assertions.assertEquals(true, syr.isPublic());
    }
}
