package org.springjeopardy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springjeopardy.model.QuestionModel;
import org.springjeopardy.service.QuestionService;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/random")
    public QuestionModel getRandomQuestion() {
        return questionService.getRandomQuestion();
    }

    @GetMapping("/random/{round}")
    public QuestionModel getRandomQuestion(@PathVariable String round) {
        return questionService.getRandomQuestion(round);
    }

    @GetMapping("/{question}")
    public QuestionModel findByQuestion(@PathVariable String question) {
        return questionService.getByQuestion(question);
    }
}
