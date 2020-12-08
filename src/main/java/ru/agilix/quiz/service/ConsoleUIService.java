package ru.agilix.quiz.service;

import org.springframework.stereotype.Service;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;

@Service
public class ConsoleUIService implements UIService {
    private final IOService readerWriter;

    public ConsoleUIService(IOService readerWriter) {
        this.readerWriter = readerWriter;
    }

    @Override
    public User getUser() {
        readerWriter.displayText("Enter your First name: ");
        String firstName = readerWriter.getText();

        readerWriter.displayText("Enter your Last name: ");
        String lastName = readerWriter.getText();
        return new User(firstName + " " + lastName);
    }

    @Override
    public void displayQuestion(Question question) {
        String text = "\n" + question.getId() + ".) " + question.getText();

        for (Answer answer : question.getAnswers()) {
            text += "\n\t [" + answer.getId() + "] " + answer.getText();
        }
        readerWriter.displayText(text);
    }

    @Override
    public void displayResultsFor(User user) {
        readerWriter.displayText("Score for student " + user.getUsername() + " is: " + user.getScore() + "\n");
    }

    @Override
    public String getAnswer() {
        readerWriter.displayText("\nType your answer: ");
        return readerWriter.getText();
    }
}
