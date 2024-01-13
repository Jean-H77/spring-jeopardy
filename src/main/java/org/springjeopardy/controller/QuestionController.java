package org.springjeopardy.controller;

import lombok.RequiredArgsConstructor;
import org.springjeopardy.service.QuestionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

}
