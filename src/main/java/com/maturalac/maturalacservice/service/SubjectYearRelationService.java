package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.ExamYear;
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

    public List<SubjectYearRelation> getSubjectYearRelations(boolean isPublic) {
        if (isPublic) {
            return this.getAllPublicSubjectYearRelations();
        }
        return this.getAllSubjectYearRelations();
    }

    public List<SubjectYearRelation> getAllSubjectYearRelations() {
        return this.subjectYearRelationRepository.findAll();
    }

    public List<SubjectYearRelation> getAllPublicSubjectYearRelations() {
        return this.subjectYearRelationRepository.findAllByIsPublic(true);
    }

    public SubjectYearRelation publishSubjectYearRelation(SubjectYearRelation subjectYearRelation) {
        subjectYearRelation.setPublic(true);
        return this.subjectYearRelationRepository.save(subjectYearRelation);
    }

    public List<SubjectYearRelation> getAllSubjectYearRelationsBySubjectAndPublic(
            Subject subject, boolean isPublic) {
        if (isPublic) {
            return this.subjectYearRelationRepository
                    .findAllBySubjectAndAndIsPublic(subject, isPublic);
        }
        return this.subjectYearRelationRepository.findAllBySubject(subject);
    }

    public SubjectYearRelation saveSubjectYearRelation(SubjectYearRelation subjectYearRelation) {
        return this.subjectYearRelationRepository.save(subjectYearRelation);
    }

    public List<SubjectYearRelation> getAllBySubject(Subject subject) {
        return this.subjectYearRelationRepository.findAllBySubject(subject);
    }

    public List<SubjectYearRelation> getSubjectYearRelationsBySubject(Subject subject) {
        return this.subjectYearRelationRepository.findAllBySubject(subject);
    }

    public SubjectYearRelation getOrCreateSubjectYearRelation(SubjectYearRelation subjectYearRelation) {
        SubjectYearRelation syr = this.subjectYearRelationRepository
                .findBySubjectAndAndExamYear(subjectYearRelation.getSubject(),
                        subjectYearRelation.getExamYear())
                .orElseGet(() -> this.saveNewSubjectYearRelation(subjectYearRelation.getSubject(),
                        subjectYearRelation.getExamYear()));
        return syr;
    }

    public SubjectYearRelation saveNewSubjectYearRelation(Subject subject, ExamYear exam) {
        SubjectYearRelation subjectYearRelation = new SubjectYearRelation();
        subjectYearRelation.setSubject(subject);
        subjectYearRelation.setExamYear(exam);
        subjectYearRelation.setPublic(true);
        return this.subjectYearRelationRepository.save(subjectYearRelation);
    }
}
