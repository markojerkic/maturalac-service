package com.maturalac.maturalacservice.data.service;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.data.repository.SubjectYearRelationRepository;
import com.maturalac.maturalacservice.data.repository.SubjectsRepository;
import com.maturalac.maturalacservice.service.SubjectYearRelationService;
import com.maturalac.maturalacservice.service.SubjectsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SubjectsServiceTests {
    @Mock
    private SubjectsRepository subjectsRepository;
    @Mock
    private SubjectYearRelationRepository subjectYearRelationRepository;
    @InjectMocks
    private SubjectYearRelationService subjectYearRelationService;
    @InjectMocks
    private SubjectsService subjectsService;

    private Subject getMockSubject(String name) {
        return new Subject(UUID.fromString("54"), name, Collections.emptyList());
    }

    ExamYear ey = new ExamYear(UUID.fromString("54"), "2020 jesen");
    List<SubjectYearRelation> syrs = Arrays.asList(new SubjectYearRelation(UUID.fromString("54"), true,
                    getMockSubject("Matematika"), ey),
            new SubjectYearRelation(UUID.fromString("54"), false,
                    getMockSubject("Matematika"), ey));
    @BeforeEach
    public void setUp() {
        given(subjectsRepository.findAll()).willReturn(Collections.singletonList(getMockSubject("Matematika")));
    }

    @Test
    public void getAllSubjectsPublicTest() {
        given(subjectYearRelationRepository.findAllBySubjectAndAndIsPublic(
                eq(getMockSubject("Matematika")), eq(true)))
                .willReturn(Collections.singletonList(syrs.get(0)));

        List<Subject> returnedSubjects = this.subjectsService.getAllSubjectsByIsPublic(true);
        verify(subjectYearRelationRepository, times(1))
                .findAllBySubjectAndAndIsPublic(any(Subject.class), eq(true));

        returnedSubjects.forEach(rs -> rs.getSubjectYearRelations().forEach(syr -> assertTrue(syr.isPublic())));
    }

    @Test
    public void getAllSubjectsAllTest() {
        given(subjectYearRelationRepository.findAllBySubject(eq(getMockSubject("Matematika"))))
                .willReturn(syrs);
        
        this.subjectsService.getAllSubjectsByIsPublic(false);
        verify(subjectYearRelationRepository, times(1))
                .findAllBySubject(any(Subject.class));
    }
}
