package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.Question;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllBySubjectYearRelationOrderByQuestionNumberAsc(SubjectYearRelation subjectYearRelation);
}
