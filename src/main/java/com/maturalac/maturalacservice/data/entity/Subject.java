package com.maturalac.maturalacservice.data.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subjects", uniqueConstraints = {
        @UniqueConstraint(name="subject_name", columnNames="subject_name")
})
public class Subject {
    @Id
    @GeneratedValue()
    private Long id;

    @NotNull
    @Column(name="subject_name")
    private String subjectName;

    @Transient
    private List<SubjectYearRelation> subjectYearRelations;
}
