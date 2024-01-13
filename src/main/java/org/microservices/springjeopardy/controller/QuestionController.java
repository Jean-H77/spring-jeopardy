package org.microservices.springjeopardy.controller;

import lombok.RequiredArgsConstructor;
import org.microservices.springjeopardy.QuestionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

}
