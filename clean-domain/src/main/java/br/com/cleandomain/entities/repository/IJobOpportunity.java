package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IJobOpportunity {

    long getId();
    String getTitle();

    String getDescription();

    String getLanguage();

    String getMinimumProfile();

    LocalDate getStartDate();

    LocalDate getClosingDate();

    String getEducationLevel();

    String getSalary();

    Criterion getCriterion();

    User getUser();

    Company getCompany();

    Customer getCustomer();

    boolean getStatus();

    void setId(long id);
    void setTitle(String title);

    void setDescription(String description);

    void setLanguage(String language);

    void setMinimumProfile(String minimumProfile);

    void setClosingDate(LocalDate closingDate);

    void setEducationLevel(String educationLevel);

    void setSalary(String salary);

    void setCriterion(Criterion criterion);

    void setUser(User user);

    void setCompany(Company company);

    void setCustomer(Customer customer);

    void setStatus(boolean status);

    boolean isStatus();

    JobOpportunity listAll();

    JobOpportunity delete(long id);

    List<IJobOpportunity> listAllCustomer(ICpf cpf);
}
