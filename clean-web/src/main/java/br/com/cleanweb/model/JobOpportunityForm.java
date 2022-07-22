package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.IJobOpportunity;
import lombok.Data;

import java.time.LocalDate;
@Data
public class JobOpportunityForm {

    private long id;
    private String title;
    private String description;
    private String language;
    private String minimumProfile;
    private LocalDate startDate;
    private LocalDate closingDate;
    private String educationLevel;
    private String salary;
    private CriterionForm criterion;
    private UserForm user;
    private CompanyForm company;
    private CustomerForm customer;
    private boolean status;

    public JobOpportunityForm(IJobOpportunity jobOpportunity) {
        this.id = jobOpportunity.getId();
        this.title = jobOpportunity.getTitle();
        this.description = jobOpportunity.getDescription();
        this.language = jobOpportunity.getLanguage();
        this.minimumProfile = jobOpportunity.getMinimumProfile();
        this.startDate = jobOpportunity.getStartDate();
        this.closingDate = jobOpportunity.getClosingDate();
        this.educationLevel = jobOpportunity.getEducationLevel();
        this.salary = jobOpportunity.getSalary();
        this.criterion = new CriterionForm(jobOpportunity.getCriterion());
        this.user = new UserForm(jobOpportunity.getUser());
        this.company = new CompanyForm(jobOpportunity.getCompany());
        this.customer = new CustomerForm(jobOpportunity.getCustomer());
    }
}
