package org.springjeopardy.service;

import lombok.RequiredArgsConstructor;
import org.springjeopardy.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
}
