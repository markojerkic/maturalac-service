package com.maturalac.maturalacservice.data.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name="subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(name="subject_name", columnNames="subject_name")
})
public class Subject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="subject_name", columnDefinition = "text")
    private String subjectName;

    @Transient
    private List<SubjectYearRelation> subjectYearRelations;
}
