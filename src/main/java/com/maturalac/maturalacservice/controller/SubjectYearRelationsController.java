package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.data.entity.SubjectYearRelation;
import com.maturalac.maturalacservice.service.SubjectYearRelationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subjectyearrelation")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor()
public class SubjectYearRelationsController {
    private final SubjectYearRelationService subjectYearRelationService;

    @GetMapping()
    public ResponseEntity<List<SubjectYearRelation>> getAllSubjectYearsRelations(
            @RequestParam(value = "isPublic", required = false, defaultValue = "true")
                    boolean isPublic) {
            List<SubjectYearRelation> subjectYearRelations = this.subjectYearRelationService
                    .getSubjectYearRelations(isPublic);
            return ResponseEntity.ok(subjectYearRelations);
    }
}
