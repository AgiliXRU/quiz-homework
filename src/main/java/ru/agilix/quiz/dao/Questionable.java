package ru.agilix.quiz.dao;

import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.utils.QuestionProcessor;

import java.util.List;

public interface Questionable {
    List<Question> getAllQuestions();
}

