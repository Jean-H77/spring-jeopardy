package org.springjeopardy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springjeopardy.entity.QuestionEntity;
import org.springjeopardy.model.QuestionModel;
import org.springjeopardy.repository.QuestionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionModel getRandomQuestion() {
        QuestionEntity questionEntity = questionRepository.getRandomQuestion();
        return toModel(questionEntity);
    }

    public Optional<QuestionModel> getRandomQuestion(String value) {
        Optional<QuestionEntity> questionEntity = Optional.ofNullable(questionRepository.getRandomQuestion(value));
        return questionEntity.map(QuestionService::toModel);
    }

    private static QuestionModel toModel(QuestionEntity questionEntity) {
        return QuestionModel.builder()
                .question(questionEntity.getQuestion())
                .value(questionEntity.getValue())
                .airDate(questionEntity.getAirDate())
                .round(questionEntity.getRound())
                .answer(questionEntity.getAnswer())
                .showNumber(questionEntity.getShowNumber())
                .build();
    }
}
