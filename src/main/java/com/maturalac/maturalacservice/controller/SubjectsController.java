package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.service.SubjectsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subjects")
@AllArgsConstructor()
@CrossOrigin(origins = "*")
public class SubjectsController {

    private final SubjectsService subjectsService;

    @GetMapping()
    public ResponseEntity<List<Subject>> getAllSubjectYearsRelations(
            @RequestParam(value = "isPublic", required = false, defaultValue = "true")
                    boolean isPublic) {
        List<Subject> subjects = this.subjectsService
                .getAllSubjects(isPublic);
        return ResponseEntity.ok(subjects);
    }
}
