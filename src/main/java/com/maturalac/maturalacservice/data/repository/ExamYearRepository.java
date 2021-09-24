package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.ExamYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamYearRepository extends JpaRepository<ExamYear, Long> {
    ExamYear findByExamName(String examName);
    List<ExamYear> findByOrderByExamNameAsc();
}
