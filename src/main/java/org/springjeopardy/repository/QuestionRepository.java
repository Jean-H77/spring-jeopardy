package org.springjeopardy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springjeopardy.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {

    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 1", nativeQuery = true)
    QuestionEntity getRandomQuestion();

    @Query(value = "SELECT * FROM questions q WHERE q.round = :round ORDER BY RAND() LIMIT 1", nativeQuery = true)
    QuestionEntity getRandomQuestion(@Param("round") String round);
}
