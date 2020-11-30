package ru.agilix.quiz.service;

import ru.agilix.quiz.domain.Question;

import java.io.IOException;
import java.util.List;

interface QuestionService {
    List<Question> getAllQuestions() throws IOException;
}