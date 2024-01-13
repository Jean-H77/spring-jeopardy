package org.springjeopardy.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Getter
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int showNumber;
    private Date airDate;
    private String round;
    private String value;
    private String question;
    private String answer;
}
