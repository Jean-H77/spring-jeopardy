package org.microservices.springjeopardy;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.microservices.springjeopardy.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
}
