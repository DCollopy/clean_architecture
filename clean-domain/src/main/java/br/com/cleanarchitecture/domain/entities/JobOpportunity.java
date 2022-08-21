package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class JobOpportunity {

    private long id;
    private String title;
    private String description;
    private String language;
    private Double minimumProfile = 0.0;
    private final LocalDate startDate = LocalDate.now();
    private LocalDate closingDate;
    private String educationLevel;
    private String salary;
    private Set<Criterion> criterion;
    private Customer customer;
    private AnswerOpportunity answerOpportunity;
    private boolean status;

    public JobOpportunity() {
    }
    public JobOpportunity(String title, String description, String language,
                          LocalDate closingDate, String educationLevel, String salary,
                          Set<Criterion> criterion,Customer customer) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.closingDate = closingDate;
        this.educationLevel = educationLevel;
        this.salary = salary;
        this.criterion = criterion;
        this.customer = customer;
    }

    public JobOpportunity(String title, String description, String language,
                          LocalDate closingDate, String educationLevel, String salary, Set<Criterion> criterion,
                          Customer customer,double minimumProfile) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.closingDate = closingDate;
        this.educationLevel = educationLevel;
        this.salary = salary;
        this.criterion = criterion;
        this.customer = customer;
        this.minimumProfile = minimumProfile;
    }

    public JobOpportunity(Long id,String title, String description, String language,
                          LocalDate closingDate, String educationLevel, String salary,
                          Set<Criterion> criterion, Customer customer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.language = language;
        this.closingDate = closingDate;
        this.educationLevel = educationLevel;
        this.salary = salary;
        this.criterion = criterion;
        this.customer = customer;
    }

    public JobOpportunity(AnswerOpportunity answerOpportunity){
        this.answerOpportunity = answerOpportunity;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public double getMinimumProfile() {
        return minimumProfile;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public String getSalary() {
        return salary;
    }

    public Set<Criterion> getCriterion() {
        return criterion;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double setMinimumProfile(double minimumProfile) {
        this.minimumProfile = minimumProfile;
        return minimumProfile;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setCriterion(Set<Criterion> criterion) {
        this.criterion = criterion;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return true;
    }

    public JobOpportunity listAll(){
        return this;
    }

    public JobOpportunity delete(long id){
        return this;
    }

}
