package ru.agilix.quiz.utils;

import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public interface ResourceReader {
    Iterable<CSVRecord> getRecords();
}
