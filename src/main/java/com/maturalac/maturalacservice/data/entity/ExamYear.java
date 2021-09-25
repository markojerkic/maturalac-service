package com.maturalac.maturalacservice.data.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="exam_year", uniqueConstraints = {
        @UniqueConstraint(name="exam_name", columnNames="exam_name")
})
public class ExamYear {
    @Id
    @GeneratedValue()
    private UUID id;

    @NotNull
    @Column(name="exam_name")
    private String examName;
}
