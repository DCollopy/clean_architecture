package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.SchoolingLevel;

import java.time.LocalDate;


public class SchoolingLevelConverter {

    public SchoolingLevelConverter() {
    }

    public SchoolingLevel convertToSchoolingLevel(String name, String educationLevel,
                                                  LocalDate startDate, LocalDate endDate) {
        return new SchoolingLevel(name, educationLevel, startDate, endDate);
    }
}
