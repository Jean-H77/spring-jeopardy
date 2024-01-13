package org.springjeopardy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springjeopardy.model.QuestionModel;
import org.springjeopardy.service.QuestionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/random")
    public QuestionModel getRandomQuestion() {
        return questionService.getRandomQuestion();
    }
}
