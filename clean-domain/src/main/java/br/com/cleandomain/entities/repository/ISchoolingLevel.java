package br.com.cleandomain.entities.repository;

import java.time.LocalDate;

public interface ISchoolingLevel {
    String getName();

    String getEducationLevel();

    LocalDate getStartDate();

    LocalDate getEndDate();

    void setName(String name);

    void setStartDate(java.time.LocalDate startDate);

    void setEndDate(java.time.LocalDate endDate);
}
