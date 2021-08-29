package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamYearRepository extends JpaRepository<ExamYear, Long> {
    ExamYear findByExamName(String examName);
}
