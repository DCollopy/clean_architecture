package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.usecases.DateValidation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateValidationTest {

    IDateValidation dateValidation = new DateValidation();

    @Test
    void formatDate() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        String expected = "01/01/2020";
        String actual = dateValidation.formatDate(date);
        assertEquals(expected, actual);
    }

    @Test
    void timeExpire() {
        LocalDate date = LocalDate.of(2020, 1, 1);
        boolean expected = false;
        boolean actual = dateValidation.timeControl(date);
        assertEquals(expected, actual);

    }

    @Test
    void subtractDays() {
        LocalDate endDate = LocalDate.of(2020, 1, 1);
        LocalDate startDate = LocalDate.of(2020, 1, 2);
        double expected = 1;
        double actual = dateValidation.subtractDays(endDate, startDate);
        assertEquals(expected, actual);
    }
}