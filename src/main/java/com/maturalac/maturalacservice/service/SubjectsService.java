package com.maturalac.maturalacservice.service;

import com.maturalac.maturalacservice.data.entity.Subject;
import com.maturalac.maturalacservice.data.repository.SubjectsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor()
public class SubjectsService {
    private final SubjectsRepository subjectsRepository;

    public List<Subject> getAllSubjects(boolean isPublic) {
        if (isPublic) {
            return this.subjectsRepository.findAll();
        }
        return this.subjectsRepository.findAll();
    }
}
