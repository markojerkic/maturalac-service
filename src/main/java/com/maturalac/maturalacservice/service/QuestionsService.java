package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.Question;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.data.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuestionsService {
    private final QuestionRepository questionRepository;
    private final SubjectYearRelationService subjectYearRelationsService;

    public Question saveQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    public List<Question> getQuestionsBySubjectYearRelation(SubjectYearRelation subjectYearRelation) {
        return this.questionRepository.findAllBySubjectYearRelationOrderByQuestionNumberAsc(subjectYearRelation);
    }

    public List<Question> getQuestionsBySubjectYearRelationId(Long id) {
        SubjectYearRelation subjectYearRelation = new SubjectYearRelation();
        subjectYearRelation.setId(id);
        return this.questionRepository.findAllBySubjectYearRelationOrderByQuestionNumberAsc(subjectYearRelation);
    }

    public Question saveNewQuestion(Question question) {
        SubjectYearRelation subjectYearRelation = this.subjectYearRelationsService
                .getOrCreateSubjectYearRelation(question.getSubjectYearRelation());
        question.setSubjectYearRelation(subjectYearRelation);
        return this.questionRepository.save(question);
    }
}
