package br.com.cleandomain.entities.repository;

public interface ISchoolingLevel {
    String getName();

    java.time.LocalDate getStartDate();

    java.time.LocalDate getEndDate();

    void setName(String name);

    void setStartDate(java.time.LocalDate startDate);

    void setEndDate(java.time.LocalDate endDate);
}
