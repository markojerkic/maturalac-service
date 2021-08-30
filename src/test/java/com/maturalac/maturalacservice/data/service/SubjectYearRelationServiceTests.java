package com.maturalac.maturalacservice.data.service;

import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.data.repository.SubjectYearRelationRepository;
import com.maturalac.maturalacservice.service.SubjectYearRelationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SubjectYearRelationServiceTests {

    private SubjectYearRelationService subjectYearRelationService;
    @Mock
    private SubjectYearRelationRepository subjectYearRelationRepository;

    @BeforeEach
    void setUp() {
        this.subjectYearRelationService = new SubjectYearRelationService(subjectYearRelationRepository);
    }

    @Test
    public void publishSubjectYearRelationTest() {
        SubjectYearRelation syr = new SubjectYearRelation();
        this.subjectYearRelationService.publishSubjectYearRelation(syr);
        ArgumentCaptor<SubjectYearRelation> captor = ArgumentCaptor
                .forClass(SubjectYearRelation.class);

        verify(this.subjectYearRelationRepository).save(captor.capture());
        SubjectYearRelation capturedSyr = captor.getValue();
        assert(capturedSyr.isPublic());
    }
}
