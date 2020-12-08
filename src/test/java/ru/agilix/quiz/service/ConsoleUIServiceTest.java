package ru.agilix.quiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.agilix.quiz.domain.Answer;
import ru.agilix.quiz.domain.Question;
import ru.agilix.quiz.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ConsoleUIServiceTest {

    @Mock
    private IOService readerWriter;

    private ConsoleUIService consoleUIService;

    @BeforeEach
    void setUp() {
        consoleUIService = new ConsoleUIService(readerWriter);
    }

    @Test
    void getUser() {
        given(readerWriter.getText()).willReturn("test");
        User user = consoleUIService.getUser();

        assertThat(user.getUsername()).isEqualTo("test test");
    }

    @Test
    void displayQuestion() {
        List<Answer> answers = Arrays.asList(new Answer(0, "a", true));

        consoleUIService.displayQuestion(new Question(1, "test", answers));

        verify(readerWriter).displayText("\n1.) test\n\t [A] a");
    }

    @Test
    void displayResultsFor() {
        consoleUIService.displayResultsFor(new User("test"));

        verify(readerWriter).displayText("Score for student test is: 0\n");
    }

    @Test
    void getAnswer() {
        given(readerWriter.getText()).willReturn("test");

        String answer = consoleUIService.getAnswer();

        assertThat(answer).isEqualTo("test");
    }



}