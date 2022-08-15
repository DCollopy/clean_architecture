package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

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
    private CustomerForm customer;
    private boolean status;

    public JobOpportunityForm(JobOpportunity jobOpportunity) {
        this.title = jobOpportunity.getTitle();
        this.description = jobOpportunity.getDescription();
        this.language = jobOpportunity.getLanguage();
        this.minimumProfile = jobOpportunity.getMinimumProfile();
        this.startDate = jobOpportunity.getStartDate();
        this.closingDate = jobOpportunity.getClosingDate();
        this.educationLevel = jobOpportunity.getEducationLevel();
        this.salary = jobOpportunity.getSalary();
        this.criterion = jobOpportunity.getCriterion().stream().map(CriterionForm::new).collect(Collectors.toSet());
        this.customer = new CustomerForm(jobOpportunity.getCustomer());
    }

    public JobOpportunity convertToJobOpportunity() {
        return new JobOpportunity(this.getTitle(),
                this.getDescription(),
                this.getLanguage(),
                this.getClosingDate(),
                this.getEducationLevel(),
                this.getSalary(),
                this.getCriterion().stream().map(CriterionForm::convertToCriterion).collect(Collectors.toSet()),
                new CustomerForm().convertCustomer(),
                this.getMinimumProfile());
    }
}
