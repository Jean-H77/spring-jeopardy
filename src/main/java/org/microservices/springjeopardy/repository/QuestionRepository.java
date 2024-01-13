package org.microservices.springjeopardy.repository;

import org.microservices.springjeopardy.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {
}
