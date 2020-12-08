package ru.agilix.quiz.service;

import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;

public interface UIService {
    User getUser();

    void displayQuestion(Question question);

    String getAnswer();

    void displayResultsFor(User user);
}
