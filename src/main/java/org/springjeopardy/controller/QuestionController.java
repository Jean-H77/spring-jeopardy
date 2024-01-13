package org.springjeopardy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springjeopardy.model.QuestionModel;
import org.springjeopardy.service.QuestionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("api/question")
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
        Optional<QuestionModel> questionModelOptional = questionService.getRandomQuestion(round);
        if(questionModelOptional.isPresent()) {
            return questionModelOptional.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find round of " + round);
    }

    @GetMapping("/{question}")
    public QuestionModel findByQuestion(@PathVariable String question) {
        Optional<QuestionModel> questionModelOptional = questionService.getByQuestion(question);
        if(questionModelOptional.isPresent()) {
            return questionModelOptional.get();
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find jeopardy data of the question" + question);
    }
}
