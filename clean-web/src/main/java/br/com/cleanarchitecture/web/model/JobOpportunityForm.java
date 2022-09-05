package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class JobOpportunityForm {

    private String title;
    private String description;
    private String language;
    private double minimumProfile;
    private LocalDate startDate;
    private LocalDate closingDate;
    private String educationLevel;
    private String salary;
    private Set<CriterionForm> criterion;
    private String cpf;
    private boolean status;

    public JobOpportunityForm(){}

    public JobOpportunity convertToJobOpportunity() {
        return new JobOpportunity(this.getTitle(),
                this.getDescription(),
                this.getLanguage(),
                this.getClosingDate(),
                this.getEducationLevel(),
                this.getSalary(),
                new CriterionForm().convertToCriterionSet(this.getCriterion()));
    }
}
