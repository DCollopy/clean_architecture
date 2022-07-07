package br.com.cleandomain.usecases.validation;


import br.com.cleandomain.entities.IJobOpportunity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateValidation implements IDateValidation {
    IJobOpportunity jobOpportunity;

    public DateValidation(IJobOpportunity jobOpportunity) {
        this.jobOpportunity = jobOpportunity;
    }

    public DateValidation() {
    }

    public  String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate alwaysUpdateEndTime() {
        return LocalDate.now();
    }

    public boolean timeControl(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    public boolean timeExpire(LocalDate date) {
        if(date.isBefore(LocalDate.now())){
            return jobOpportunity.isStatus();
        }
        return false;
    }

    public double subtractDays(LocalDate endDate, LocalDate startDate) {
        return endDate.toEpochDay() - startDate.toEpochDay();
    }

    public boolean finish(LocalDate endDate) {
        return endDate.isEqual(LocalDate.now());
    }

    public LocalDate isExpired(boolean status, LocalDate closingDate) {
        if(status) {
            return closingDate;
        }
        return closingDate;
    }
}
