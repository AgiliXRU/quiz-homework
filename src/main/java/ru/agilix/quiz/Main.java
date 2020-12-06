package ru.agilix.quiz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.service.QuestionFileService;
import ru.agilix.quiz.utils.CSVProcessor;
import ru.agilix.quiz.utils.QuestionProcessor;

import java.util.Scanner;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class Main {

    @Bean
    QuestionProcessor csvProcessor(@Value("${questions.file}") String path) {
        return new CSVProcessor(path);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionFileService service = context.getBean(QuestionFileService.class);
        int score = 0;

        System.out.println("Enter your First name: ");
        String firstName = scanner.next();
        System.out.println("Enter your Last name: ");
        String lastName = scanner.next();

        for (Question question : service.getAllQuestions()) {
            System.out.printf("\n%d.) %s\n", question.getId(), question.getText());

            for (Answer answer : question.getAnswers()) {
                System.out.printf("\t [%s] %s\n", answer.getId(), answer.getText());
            }
            System.out.println("\nType your answer: ");
            score += question.scoreAnswer(scanner.next());
        }

        System.out.printf("Score for student %s %s is: %d\n", firstName, lastName, score);
    }
}
