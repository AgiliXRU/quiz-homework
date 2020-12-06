package ru.agilix.quiz;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.service.QuestionFileService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionFileService service = context.getBean(QuestionFileService.class);
        for (Question question : service.getAllQuestions()) {
            System.out.printf("\n%d.) %s\n", question.getId(), question.getText());

            for (Answer answer : question.getAnswers()) {
                System.out.printf("\t [%s] %s\n", answer.getId(), answer.getText());
            }
        }
    }
}
