package ru.agilix.quiz.service;

import ru.agilix.quiz.domain.Question;

import java.util.List;

interface QuestionService {
    Question getById(int id);

    List<Question> loadAllQuestions();
}