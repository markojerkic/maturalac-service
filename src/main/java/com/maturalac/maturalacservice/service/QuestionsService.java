package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import com.maturalac.maturalacservice.data.entity.Question;
import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.data.entity.util.AnswerType;
import com.maturalac.maturalacservice.data.repository.QuestionRepository;
import com.maturalac.maturalacservice.data.repository.QuestionsPagedRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionsService {
    private final QuestionRepository questionRepository;
    private final SubjectYearRelationService subjectYearRelationsService;
    private final QuestionsPagedRepository questionsPagedRepository;

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

    public Page<Question> getQuestionsPage(Pageable pageable, Optional<String> question,
                                           Optional<String> superQuestion,
                                           Optional<String> answer,
                                           Optional<AnswerType> answerType,
                                           Optional<Subject> subject,
                                           Optional<ExamYear> examYear) {
        return this.questionsPagedRepository.findAll(this.createQuerySpecification(question, superQuestion, answer,
                answerType, subject, examYear), pageable);
    }

    private Specification<Question> createQuerySpecification(Optional<String> question,
                                                             Optional<String> superQuestion,
                                                             Optional<String> answer,
                                                             Optional<AnswerType> answerType,
                                                             Optional<Subject> subject,
                                                             Optional<ExamYear> examYear) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (question.isPresent()) {
                predicates.add(criteriaBuilder.like(root.get("question"), "%"+question.get()+"%"));
            }
            if (superQuestion.isPresent()) {
                predicates.add(criteriaBuilder.like(root.get("superQuestion").get("question"),
                        "%"+superQuestion.get()+"%"));
            }
            if (answer.isPresent()) {
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("ansA"), "%"+answer.get()+"%"),
                        criteriaBuilder.like(root.get("ansB"), "%"+answer.get()+"%"),
                        criteriaBuilder.like(root.get("ansC"), "%"+answer.get()+"%"),
                        criteriaBuilder.like(root.get("ansD"), "%"+answer.get()+"%")
                ));
            }
            if (subject.isPresent()) {
                predicates.add(criteriaBuilder.equal(root.get("subjectYearRelation").get("subject"), subject.get()));
            }
            if (examYear.isPresent()) {
                predicates.add(criteriaBuilder.equal(root.get("subjectYearRelation").get("examYear"), examYear.get()));
            }
            if (answerType.isPresent()) {
                predicates.add(criteriaBuilder.equal(root.get("answerType"), answerType.get()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
