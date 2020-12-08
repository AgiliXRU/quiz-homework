package ru.agilix.quiz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ru.agilix.quiz.utils.CsvReader;
import ru.agilix.quiz.service.QuestionFileService;
import ru.agilix.quiz.utils.ResourceReader;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")
public class Main {

//    @Bean
//    QuestionProcessor csvProcessor(@Value("${questions.file}") String path) {
//        return new CSVProcessor(this.getClass().getResourceAsStream(path));
//    }

    @Bean
    ResourceReader csvReader(@Value("${questions.file}") String path) {
        return new CsvReader(path);
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuestionFileService service = context.getBean(QuestionFileService.class);
        service.runQuiz();
    }
}
