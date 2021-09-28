package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.Question;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionsPagedRepository extends PagingAndSortingRepository<Question, Long> {

}
