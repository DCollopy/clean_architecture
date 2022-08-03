package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.ProfessionalExperience;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ProfessionalExperienceForm {

    private String companyName;
    private String function;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProfessionalExperienceForm(ProfessionalExperience professionalExperience) {
        this.companyName = professionalExperience.getCompanyName();
        this.function = professionalExperience.getFunction();
        this.description = professionalExperience.getDescription();
        this.startDate = professionalExperience.getStartDate();
        this.endDate = professionalExperience.getEndDate();
    }

    public ProfessionalExperienceForm() {
    }

    public ProfessionalExperience convertProfessionalExperienceFormToProfessionalExperience() {
        return new ProfessionalExperience(this.companyName, this.function, this.description, this.startDate, this.endDate);
    }
}
