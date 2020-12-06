package ru.agilix.quiz.service;

import org.springframework.stereotype.Service;
import ru.agilix.quiz.dao.QuestionDao;
import ru.agilix.quiz.dao.Questionable;
import ru.agilix.quiz.domain.Question;

import java.util.List;

@Service
public class QuestionFileService implements QuestionService {
    private Questionable dao;

    public QuestionFileService(Questionable dao) {
        this.dao = dao;
    }

    public List<Question> getAllQuestions() {
        return dao.getAllQuestions();
    }
}
