package ru.agilix.quiz.service;

import ru.agilix.quiz.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
}