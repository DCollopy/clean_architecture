package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class JobOpportunityForm {

    private long id;
    private String title;
    private String description;
    private String language;
    private double minimumProfile;
    private LocalDate startDate;
    private LocalDate closingDate;
    private String educationLevel;
    private String salary;
    private String cpf;
    private boolean status;
    private Set<CriterionForm> criterion;

    public JobOpportunityForm(){}

    public JobOpportunity convertToJobOpportunity() {
        return new JobOpportunity(
                this.getTitle(),
                this.getDescription(),
                this.getLanguage(),
                this.getClosingDate(),
                this.getEducationLevel(),
                this.getSalary(),
                this.getCriterion().stream().map(CriterionForm::convertToCriterion).collect(Collectors.toSet()),
                this.getMinimumProfile());
    }

    public Set<JobOpportunity> convertToJob(JobOpportunity jobOpportunity) {
        return Stream.of(new JobOpportunity(
                jobOpportunity.getTitle(),
                jobOpportunity.getDescription(),
                jobOpportunity.getLanguage(),
                jobOpportunity.getClosingDate(),
                jobOpportunity.getEducationLevel(),
                jobOpportunity.getSalary(),
                jobOpportunity.getCriterion(),
                jobOpportunity.getMinimumProfile())).collect(Collectors.toSet());
    }
}
