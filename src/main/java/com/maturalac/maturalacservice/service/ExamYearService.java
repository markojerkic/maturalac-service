package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import com.maturalac.maturalacservice.data.repository.ExamYearRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
@AllArgsConstructor
public class ExamYearService {
    private final ExamYearRepository examYearRepository;

    public List<ExamYear> getExamYears() {
        return this.examYearRepository.findByOrderByExamNameAsc();
    }
}
