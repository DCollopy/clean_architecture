package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.IProfessionalExperience;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ProfessionalExperience implements IProfessionalExperience {
    private String companyName;
    private String function;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProfessionalExperience(String companyName, String function, String description, LocalDate startDate, LocalDate endDate) {
        if(companyName == null || companyName.isEmpty()) {
            throw new IllegalArgumentException("Invalid company name");
        }
        if(function == null || function.isEmpty()) {
            throw new IllegalArgumentException("Invalid function");
        }
        if(description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid description");
        }
        if(startDate == null) {
            throw new IllegalArgumentException("Invalid start date");
        }
        if(endDate == null) {
            throw new IllegalArgumentException("Invalid end date");
        }
        if(startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date greater than end date");
        }
        this.companyName = companyName;
        this.function = function;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ProfessionalExperience() {
    }

}
