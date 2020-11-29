package ru.agilix.quiz.dao;

import ru.agilix.quiz.domain.Question;

public interface Questionable {
    Question findById(int id);
}

