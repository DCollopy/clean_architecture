package br.com.cleandomain.entities.repository;

import java.time.LocalDate;

public interface IProfessionalExperience {
    String getCompanyName();

    String getFunction();

    String getDescription();

    LocalDate getStartDate();

    LocalDate getEndDate();

    void setCompanyName(String companyName);

    void setFunction(String function);

    void setDescription(String description);

    void setStartDate(LocalDate startDate);

    void setEndDate(LocalDate endDate);
}
