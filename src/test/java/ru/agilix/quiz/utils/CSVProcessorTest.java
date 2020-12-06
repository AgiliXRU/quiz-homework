package ru.agilix.quiz.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.agilix.quiz.dao.QuestionDao;
import ru.agilix.quiz.domain.Question;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CSVProcessorTest {

    @Test
    void parseOneQuestions() {
        QuestionProcessor processor = new TestableProcessor("1,test,+true,false");

        List<Question> questionList = processor.parseQuestions();

        assertThat(questionList.size()).isEqualTo(1);
        assertThat(questionList.get(0).getText()).isEqualTo("test");
    }

    @Test
    void processEmptyFile() {
        QuestionProcessor processor = new TestableProcessor("");

        List<Question> questionList = processor.parseQuestions();

        assertThat(questionList.size()).isEqualTo(0);
    }

    private class TestableProcessor extends CSVProcessor {
        private final String content;

        public TestableProcessor(String content) {
            super(null);
            this.content = content;
        }

        @Override
        public InputStream getStream() {
            return new ByteArrayInputStream(content.getBytes());
        }

    }
}