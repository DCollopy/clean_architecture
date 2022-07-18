package br.com.cleandomain.usecases.validation;

import java.time.LocalDate;

public interface IDateValidation {
    String formatDate(LocalDate date);
    LocalDate alwaysUpdateEndTime();
    boolean timeControl(LocalDate date);

    double subtractDays(LocalDate endDate, LocalDate startDate);

    boolean finish(LocalDate endDate);

    LocalDate isExpired(boolean status, LocalDate closingDate);

}
