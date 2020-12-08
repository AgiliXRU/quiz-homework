package ru.agilix.quiz.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor implements QuestionProcessor {
    private InputStream stream;

    public CSVProcessor(InputStream stream) {
        this.stream = stream;
    }

    public Iterable<CSVRecord> getRecords(InputStream stream) {
        Iterable<CSVRecord> records = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            records = CSVFormat.RFC4180.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public List<Question> parseQuestions() {
        List<Question> result = new ArrayList<>();
        for (CSVRecord record : getRecords(stream)) {
            String id = record.get(0);
            String text = record.get(1);

            List<Answer> answers = new ArrayList<>();
            for (int i = 2; i < record.size(); i++) {


                String optionText = record.get(i);
                boolean isRight = false;
                if (optionText.startsWith("+")) {
                    optionText = optionText.substring(1);
                    isRight = true;
                }
                answers.add(new Answer(i - 2, optionText, isRight));
            }

            result.add(new Question(Integer.parseInt(id), text, answers));
        }
        return result;
    }

}
