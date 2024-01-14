package org.springjeopardy.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springjeopardy.model.QuestionModel;
import org.springjeopardy.service.QuestionService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class QuestionControllerIT {

    private static final int SHOW_NUMBER = 4680;
    private static final String AIR_DATE_STRING = "2004-12-31";
    private static final String ROUND = "Double Jeopardy!";
    private static final String CATEGORY = "MUSICAL TRAINS";
    private static final String VALUE = "$2000";
    private static final String QUESTION = "In 1961 James Brown announced all aboard for this train";
    private static final String ANSWER = "Night Train";
    private static final  DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static Date airDate;

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionControllerIT.class);

    static {
        try {
            airDate = DATE_FORMAT.parse(AIR_DATE_STRING);
        } catch (Exception e) {
            LOGGER.error("Unable to convert air date string to air date object", e);
        }
    }

    private final MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    private static QuestionModel mockQuestionModel;

    @Autowired
    public QuestionControllerIT(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeAll
    public static void setUp() {
        mockQuestionModel = QuestionModel
                .builder()
                .showNumber(SHOW_NUMBER)
                .airDate(airDate)
                .round(ROUND)
                .category(CATEGORY)
                .value(VALUE)
                .question(QUESTION)
                .answer(ANSWER)
                .build();
    }

    @Test
    public void testGetByQuestion() throws Exception {
        when(questionService.getByQuestion(QUESTION)).thenReturn(mockQuestionModel);

        mockMvc.perform(get("/api/v1/question/"+QUESTION))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.showNumber").value(SHOW_NUMBER))
                .andExpect(jsonPath("$.round").value(ROUND))
                .andExpect(jsonPath("$.category").value(CATEGORY))
                .andExpect(jsonPath("$.value").value(VALUE))
                .andExpect(jsonPath("$.question").value(QUESTION))
                .andExpect(jsonPath("$.answer").value(ANSWER));

        verify(questionService, times(1)).getByQuestion(QUESTION);
    }
}
