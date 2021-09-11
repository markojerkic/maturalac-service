package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectYearRelationRepository extends JpaRepository<SubjectYearRelation, Long> {
    List<SubjectYearRelation> findAllBySubject(Subject subject);
    List<SubjectYearRelation> findAllByIsPublic(boolean isPublic);
    List<SubjectYearRelation> findAllBySubjectAndAndIsPublic(Subject year, boolean isPublic);
}
