package com.maturalac.maturalacservice.data.repository;

import com.maturalac.maturalacservice.data.entity.Question;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestionsPagedRepository extends PagingAndSortingRepository<Question, Long>,
                                                JpaSpecificationExecutor<Question> {

}
