package br.com.cleandomain.usecases.validation.iusercases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface IDateValidation {
    String formatDate(LocalDate date);
    LocalDate alwaysUpdateEndTime();
    boolean timeControl(LocalDate date);

    double subtractDays(LocalDate endDate, LocalDate startDate);

    boolean finish(LocalDate endDate);

    LocalDate isExpired(boolean status, LocalDate closingDate);

}
