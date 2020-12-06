package ru.agilix.quiz.domain;

import java.util.List;

public class Question {
    private final int id;
    private final String text;
    private final List<Answer> answers;

    public Question(int id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int scoreAnswer(String answer) {
        int score = 0;
        for(Answer a : answers) {
            if (a.getId().toLowerCase().equals(answer.toLowerCase()) && a.isRight)
                score += 1;
        }
        return score;
    }
}
