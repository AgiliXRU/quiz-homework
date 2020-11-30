package ru.agilix.quiz.dao;

import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.CVSProcessor;

import java.util.List;

public class QuestionDao implements Questionable{
    private final String path;

    public QuestionDao(String path) {
        this.path = path;

    }

    @Override
    public List<Question> getAllQuestions(CVSProcessor cvsProcessor) {
        return cvsProcessor.parseQuestions(this.getClass().getResourceAsStream(path));
    }


}
