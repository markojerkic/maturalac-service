package com.maturalac.maturalacservice.data.entity;

import com.maturalac.maturalacservice.data.entity.util.AnswerType;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="questions")
@Data
public class Question {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name="correctAns")
    private Integer correctAnswer;

    @Column(name="ansA", columnDefinition = "text")
    @NotNull
    private String ansA;

    @Column(name="ansB", columnDefinition = "text")
    @NotNull
    private String ansB;

    @Column(name="ansC", columnDefinition = "text")
    @NotNull
    private String ansC;

    @Column(name="ansD", columnDefinition = "text")
    @NotNull
    private String ansD;

    @Column(name="questionNumber")
    @NotNull
    private Integer questionNumber;

    @Column(columnDefinition = "text")
    @NotNull
    private String question;

    @Column(name="typeOfAnswer")
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private AnswerType answerType;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="question_img_id")
    private SavedFile questionImage;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ans_img_id")
    private SavedFile answerImage;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="subject_exam_year_id")
    private SubjectYearRelation subjectYearRelation;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="super_question_id")
    private SuperQuestion superQuestion;
}
