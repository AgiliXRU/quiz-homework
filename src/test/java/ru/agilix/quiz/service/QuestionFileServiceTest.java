package ru.agilix.quiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.agilix.quiz.dao.QuestionDao;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuestionFileServiceTest {
    @Mock
    private QuestionDao questionDao;

    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new QuestionFileService(questionDao);
    }

    @Test
    void getAllQuestions() {
        List<Answer> answers = Collections.singletonList(new Answer(1, "A", false));
        Question question = new Question(1, "question", answers);
        List<Question> questionList = List.of(question);
        given(questionDao.getAllQuestions()).willReturn(questionList);

        List<Question> result = questionService.getAllQuestions();

        assertThat(result).isEqualTo(questionList);
    }



}