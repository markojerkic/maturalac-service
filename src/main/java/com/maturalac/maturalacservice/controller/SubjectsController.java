package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.service.SubjectsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/subjects")
@AllArgsConstructor()
@CrossOrigin(origins = "*")
public class SubjectsController {

    private final SubjectsService subjectsService;

    @GetMapping()
    public ResponseEntity<List<Subject>> getAllSubjects(
            @RequestParam(required = false)
                    Optional<Boolean> isPublic) {
        List<Subject> subjects;
        if (isPublic.isPresent()) {
            subjects = this.subjectsService
                    .getAllSubjectsByIsPublic(isPublic.get());
        } else {
            subjects = this.subjectsService.getAllSubjects();
        }
        return ResponseEntity.ok(subjects);
    }
}
