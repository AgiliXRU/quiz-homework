package ru.agilix.quiz.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CsvReader implements ResourceReader {
    private final InputStream stream;

    public CsvReader(String path) {
        this.stream = this.getClass().getResourceAsStream(path);
    }

    @Override
    public Iterable<CSVRecord> getRecords() {
        Iterable<CSVRecord> records = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            records = CSVFormat.RFC4180.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
