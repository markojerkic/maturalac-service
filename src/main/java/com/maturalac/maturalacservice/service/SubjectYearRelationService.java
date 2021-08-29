package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.data.repository.SubjectYearRelationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectYearRelationService {
    private final SubjectYearRelationRepository subjectYearRelationRepository;

    public List<SubjectYearRelation> getAllPublicSubjectYearRelations() {
        return this.subjectYearRelationRepository.findAllByIsPublic(true);
    }

    public SubjectYearRelation publishSubjectYearRelation(SubjectYearRelation subjectYearRelation) {
        subjectYearRelation.setPublic(true);
        return this.subjectYearRelationRepository.save(subjectYearRelation);
    }

    public SubjectYearRelation saveSubjectYearRelation(SubjectYearRelation subjectYearRelation) {
        return this.subjectYearRelationRepository.save(subjectYearRelation);
    }

    public List<SubjectYearRelation> getAllBySubject(Subject subject) {
        return this.subjectYearRelationRepository.findAllBySubject(subject);
    }
}
