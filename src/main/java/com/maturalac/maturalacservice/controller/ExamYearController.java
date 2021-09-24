package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import com.maturalac.maturalacservice.service.ExamYearService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/examYears")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ExamYearController {

    private final ExamYearService examYearService;

    @GetMapping
    public ResponseEntity<List<ExamYear>> getAllExamYears() {
        return ResponseEntity.ok(this.examYearService.getExamYears());
    }
}
