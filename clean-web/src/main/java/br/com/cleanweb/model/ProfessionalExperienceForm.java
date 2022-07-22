package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.IProfessionalExperience;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ProfessionalExperienceForm {

    private String companyName;
    private String function;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProfessionalExperienceForm(IProfessionalExperience professionalExperience) {
        this.companyName = professionalExperience.getCompanyName();
        this.function = professionalExperience.getFunction();
        this.description = professionalExperience.getDescription();
        this.startDate = professionalExperience.getStartDate();
        this.endDate = professionalExperience.getEndDate();
    }
}
