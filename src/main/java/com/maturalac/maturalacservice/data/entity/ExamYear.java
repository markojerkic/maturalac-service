package com.maturalac.maturalacservice.data.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="exam_year")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamYear {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="exam_name", unique = true, columnDefinition = "text")
    private String examName;
}
