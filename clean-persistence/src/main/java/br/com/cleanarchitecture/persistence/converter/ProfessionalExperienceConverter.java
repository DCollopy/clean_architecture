package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.ProfessionalExperience;

import java.time.LocalDate;

public class ProfessionalExperienceConverter {

    public ProfessionalExperienceConverter() {
    }

    public ProfessionalExperience convertToProfessionalExperience(String companyName, String function, String description,
                                                                  LocalDate startDate, LocalDate endDate) {
        return new ProfessionalExperience(companyName, function, description, startDate, endDate);
    }
}
