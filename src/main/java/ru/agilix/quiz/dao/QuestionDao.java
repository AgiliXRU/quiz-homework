package ru.agilix.quiz.dao;

import ru.agilix.quiz.domain.Question;

public class QuestionDao implements Questionable{

    @Override
    public Question findById(int id) {
        return new Question(1, "text");
    }
}
