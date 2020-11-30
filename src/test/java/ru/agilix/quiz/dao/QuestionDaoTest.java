package ru.agilix.quiz.dao;

import org.junit.jupiter.api.Test;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.CVSProcessor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionDaoTest {

    @Test
    void getAllQuestionsShouldReturnQuestionsFromCSV() {
        QuestionDao questionDao = new QuestionDao("/some/path");

        List<Question> result = questionDao.getAllQuestions(new TestProcessor());

        assertThat(result.get(0))
                .matches(q -> q.getText().equals("test"))
                .matches(q -> q.getId() == 1);
    }

    private class TestProcessor extends CVSProcessor {
        @Override
        public List<Question> parseQuestions(InputStream stream) {
            List<Answer> answers = Collections.singletonList(new Answer(1, "A"));
            return Collections.singletonList(new Question(1, "test", answers));
        }
    }
}