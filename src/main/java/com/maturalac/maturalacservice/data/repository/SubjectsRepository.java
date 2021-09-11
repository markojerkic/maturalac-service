package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subject, Long> {
}
