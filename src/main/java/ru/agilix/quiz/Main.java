package ru.agilix.quiz;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.service.QuestionFileService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionFileService service = context.getBean(QuestionFileService.class);
        List<Question> questions = service.loadAllQuestions();

        for (Question question : questions) {
            System.out.printf("%d.) %s", question.getId(), question.getText());
        }

    }

}
