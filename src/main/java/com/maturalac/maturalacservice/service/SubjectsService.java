package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.repository.SubjectYearRelationRepository;
import com.maturalac.maturalacservice.data.repository.SubjectsRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectsService {
    private final SubjectsRepository subjectsRepository;
    private final SubjectYearRelationService subjectYearRelationService;

    public SubjectsService(SubjectsRepository subjectsRepository,
                           SubjectYearRelationRepository subjectYearRelationRepository) {
        this.subjectYearRelationService = new SubjectYearRelationService(subjectYearRelationRepository);
        this.subjectsRepository = subjectsRepository;
    }

    public List<Subject> getAllSubjectsByIsPublic(boolean isPublic) {
        return this.subjectsRepository.findAll().stream().peek(subject -> subject.setSubjectYearRelations(
                this.subjectYearRelationService
                    .getAllSubjectYearRelationsBySubjectAndPublic(subject, isPublic))).filter(subject -> subject.getSubjectYearRelations().size() > 0)
            .sorted(Comparator.comparing(Subject::getSubjectName))
                .collect(Collectors.toList());
    }

    public List<Subject> getAllSubjects() {
        return this.subjectsRepository.findByOrderBySubjectNameAsc();
    }
}
