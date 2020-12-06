package ru.agilix.quiz.utils;

import ru.agilix.quiz.domain.Question;

import java.io.InputStream;
import java.util.List;

public interface QuestionProcessor {
    InputStream getStream();
    List<Question> parseQuestions();
}
