package ru.agilix.quiz.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.CSVProcessor;
import ru.agilix.quiz.utils.QuestionProcessor;

import java.util.List;

@Service
public class QuestionDao implements Questionable{
    private QuestionProcessor questionProcessor;

    public QuestionDao(QuestionProcessor questionProcessor) {
        this.questionProcessor = questionProcessor;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionProcessor.parseQuestions();
    }
}
