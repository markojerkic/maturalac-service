package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.data.entity.Question;
import com.maturalac.maturalacservice.service.QuestionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
@AllArgsConstructor
public class QuestionsController {
    private final QuestionsService questionsService;

    @GetMapping("/{subjectYearRelationId}")
    public ResponseEntity<List<Question>> getAllQuestionsBySubjectYearRelationId(
            @PathVariable("subjectYearRelationId") Long subjectYearRelationId) {
        List<Question> questions = this.questionsService.
                getQuestionsBySubjectYearRelationId(subjectYearRelationId);
        return ResponseEntity.ok(questions);
    }
}
