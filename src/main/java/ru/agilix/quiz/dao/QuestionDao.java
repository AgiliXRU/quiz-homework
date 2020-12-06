package ru.agilix.quiz.dao;

import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.CSVProcessor;
import ru.agilix.quiz.utils.QuestionProcessor;

import java.util.List;

public class QuestionDao implements Questionable{
    private final String path;
    private QuestionProcessor questionProcessor;

    public QuestionDao(String path, QuestionProcessor questionProcessor) {
        this.path = path;
        this.questionProcessor = questionProcessor;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionProcessor.parseQuestions(this.getClass().getResourceAsStream(path));
    }


}
