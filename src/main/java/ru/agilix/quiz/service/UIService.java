package ru.agilix.quiz.service;

import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;

public interface UIService {
    User getUser();

    void display(Question question);

    void displayResultsFor(User user);

    String getAnswer();
}
