package org.microservices.springjeopardy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuestionModel {
    private int showNumber;
    private Date airDate;
    private String round;
    private String value;
    private String question;
    private String answer;
}
