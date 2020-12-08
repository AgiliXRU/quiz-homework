package ru.agilix.quiz.service;

import org.springframework.stereotype.Service;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;

import java.util.Scanner;

@Service
public class ConsoleUIService implements UIService {
    private Scanner scanner;

    public ConsoleUIService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public User getUser() {
        System.out.println("Enter your First name: ");
        String firstName = scanner.next();
        System.out.println("Enter your Last name: ");
        String lastName = scanner.next();
        return new User(firstName + " " +lastName);
    }

    @Override
    public void display(Question question) {
        System.out.printf("\n%d.) %s\n", question.getId(), question.getText());

        for (Answer answer : question.getAnswers()) {
            System.out.printf("\t [%s] %s\n", answer.getId(), answer.getText());
        }
    }

    @Override
    public void displayResultsFor(User user) {
        System.out.printf("Score for student %s is: %d\n", user.getUsername(), user.getScore());
    }

    @Override
    public String getAnswer() {
        System.out.println("\nType your answer: ");
        return scanner.next();
    }
}
