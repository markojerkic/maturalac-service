package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.service.SubjectYearRelationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subjectyearrelation")
@CrossOrigin(origins = "*")
@AllArgsConstructor()
public class SubjectYearRelationsController {
    private final SubjectYearRelationService subjectYearRelationService;

    @GetMapping()
    public ResponseEntity<List<SubjectYearRelation>> getAllSubjectYearsRelations(
            @RequestParam(defaultValue = "true")
                    boolean isPublic,
            @RequestParam(value="subjectId", required = false) Subject subject) {
        List<SubjectYearRelation> subjectYearRelations;
        if (subject != null) {
            subjectYearRelations = this.subjectYearRelationService
                    .getSubjectYearRelationsBySubject(subject);
        } else {
            subjectYearRelations = this.subjectYearRelationService
                    .getSubjectYearRelations(isPublic);
        }
            return ResponseEntity.ok(subjectYearRelations);
    }
}
