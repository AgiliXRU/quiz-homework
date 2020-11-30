package ru.agilix.quiz.service;

import ru.agilix.quiz.dao.QuestionDao;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.CVSProcessor;

import java.util.List;

public class QuestionFileService implements QuestionService {
    private CVSProcessor cvsProcessor;
    private QuestionDao dao;

    public QuestionFileService() {
    }

    public QuestionFileService(QuestionDao dao, CVSProcessor cvsProcessor) {
        this.dao = dao;
        this.cvsProcessor = cvsProcessor;
    }

    public void setDao(QuestionDao dao) {
        this.dao = dao;
    }

    public void setCvsProcessor(CVSProcessor processor) {
        this.cvsProcessor = processor;
    }

    public List<Question> getAllQuestions() {
        return dao.getAllQuestions(this.cvsProcessor);
    }
}
