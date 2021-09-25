package com.maturalac.maturalacservice.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="subject_year_relation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectYearRelation {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name="is_public", columnDefinition = "tinyint(1) default 0")
    private boolean isPublic;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn(name="exam_year_id", nullable = false)
    private ExamYear examYear;
}
