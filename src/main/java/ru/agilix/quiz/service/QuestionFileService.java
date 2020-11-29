package ru.agilix.quiz.service;

import ru.agilix.quiz.dao.Questionable;
import ru.agilix.quiz.domain.Question;
import java.util.List;

public class QuestionFileService implements QuestionService {
    private Questionable dao;

    public QuestionFileService() {

    }

    public QuestionFileService(Questionable dao) {
        this.dao = dao;
    }

    public void setDao(Questionable dao) {
        this.dao = dao;
    }

    public Question getById(int id) {
        return dao.findById(id);
    }

    public List<Question> loadAllQuestions() {
        return null;
    }
}
