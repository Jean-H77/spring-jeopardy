package org.springjeopardy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springjeopardy.entity.QuestionEntity;
import org.springjeopardy.model.QuestionModel;
import org.springjeopardy.repository.QuestionRepository;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionModel getRandomQuestion() {
        QuestionEntity questionEntity = questionRepository.getRandomQuestion();
        return toModel(questionEntity);
    }

    public QuestionModel getRandomQuestion(String round) {
        Optional<QuestionEntity> optionalQuestionEntity = Optional.ofNullable(questionRepository.getRandomQuestion(round));
        if(optionalQuestionEntity.isPresent()) {
            QuestionEntity entity = optionalQuestionEntity.get();
            return toModel(entity);
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find round of " + round);
    }

    public QuestionModel getByQuestion(String question) {
        Optional<QuestionEntity> optionalQuestionEntity = Optional.ofNullable(questionRepository.findByQuestion(question));
        if(optionalQuestionEntity.isPresent()) {
            QuestionEntity entity = optionalQuestionEntity.get();
            return toModel(entity);
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find jeopardy data of the question" + question);
    }

    private static QuestionModel toModel(QuestionEntity questionEntity) {
        return QuestionModel.builder()
                .question(questionEntity.getQuestion())
                .value(questionEntity.getValue())
                .airDate(questionEntity.getAirDate())
                .round(questionEntity.getRound())
                .category(questionEntity.getCategory())
                .answer(questionEntity.getAnswer())
                .showNumber(questionEntity.getShowNumber())
                .build();
    }
}
