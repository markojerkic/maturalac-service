package com.maturalac.maturalacservice.controller;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import com.maturalac.maturalacservice.data.entity.Question;
import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.entity.util.AnswerType;
import com.maturalac.maturalacservice.service.QuestionsService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/questions")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class QuestionsController {
    private final QuestionsService questionsService;

    @GetMapping()
    public ResponseEntity<List<Question>> getAllQuestionsBySubjectYearRelationId(
            @RequestParam("syrId") Long subjectYearRelationId) {
        List<Question> questions = this.questionsService.
                getQuestionsBySubjectYearRelationId(subjectYearRelationId);
        return ResponseEntity.ok(questions);
    }

    @PostMapping
    public ResponseEntity<Question> addNewQuestion(@RequestBody Question question) {
        Question savedQuestion = this.questionsService.saveNewQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Question>> getQuestionsPage(
            Pageable pageable,
            @RequestParam(required = false) Optional<String> question,
            @RequestParam(required = false) Optional<String> superQuestion,
            @RequestParam(required = false) Optional<String> answer,
            @RequestParam(name = "answerType", required = false) Optional<AnswerType> answerType,
            @RequestParam(name = "subject", required = false) Optional<Subject> subject,
            @RequestParam(name = "examYear", required = false) Optional<ExamYear> examYear
    ) {
        Page<Question> page = this.questionsService.getQuestionsPage(pageable,
                question, superQuestion, answer, answerType, subject, examYear);
        return ResponseEntity.ok(page);
    }
}
