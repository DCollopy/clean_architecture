package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.ISchoolingLevel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SchoolingLevel implements ISchoolingLevel {
    private String name;
    private String educationLevel;
    private LocalDate startDate;
    private LocalDate endDate;

    public SchoolingLevel(String name, String educationLevel, LocalDate startDate, LocalDate endDate) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
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
        this.name = name;
        this.educationLevel = educationLevel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
