package br.com.cleanpersistence.converter;

import br.com.cleandomain.entities.ProfessionalExperience;
import br.com.cleanpersistence.entities.ProfessionalExperienceEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalExperienceConverter {


    public ProfessionalExperience convertToProfessionalExperience() {
        ProfessionalExperienceEntity professionalExperienceEntity = new ProfessionalExperienceEntity();
        return new ProfessionalExperience(professionalExperienceEntity.getCompanyName(),
                professionalExperienceEntity.getFunctions(), professionalExperienceEntity.getDescription(),
                professionalExperienceEntity.getStartDate(), professionalExperienceEntity.getEndDate());
    }
}
