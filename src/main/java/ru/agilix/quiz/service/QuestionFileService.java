package ru.agilix.quiz.service;

import ru.agilix.quiz.dao.QuestionDao;
import ru.agilix.quiz.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionFileService implements QuestionService {
    private QuestionDao dao;

    public QuestionFileService() {

    }

    public QuestionFileService(QuestionDao dao) {
        this.dao = dao;
    }

    public void setDao(QuestionDao dao) {
        this.dao = dao;
    }

    public Question getById(int id) {
        return null;
    }

    public List<Question> loadAllQuestions() {
        return new ArrayList<Question>();
    }
}
