package com.maturalac.maturalacservice.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="subject_year_relation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectYearRelation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="is_public", columnDefinition = "tinyint(1) default 0")
    private boolean isPublic;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name="subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="exam_year_id", nullable = false)
    private ExamYear examYear;
}
