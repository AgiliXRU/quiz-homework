package ru.agilix.quiz.domain;

public class Answer {
    private final String[] answersMask = new String[]{"A", "B", "C", "D", "E", "F"};

    private final String text;
    private final int index;

    public Answer(int index, String text) {
        this.text = text;
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return answersMask[index];
    }
}
