package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.entities.repository.ICriterion;
import br.com.cleandomain.entities.repository.IJobOpportunity;
import br.com.cleandomain.usecases.validation.IJobOpportunityValidation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class JobOpportunityValidation implements IJobOpportunityValidation {

    public void validate(IJobOpportunity jobOpportunity) {
        if (jobOpportunity.getTitle() == null || jobOpportunity.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (jobOpportunity.getDescription() == null || jobOpportunity.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }
        if (jobOpportunity.getCompany() == null) {
            throw new IllegalArgumentException("Company is required");
        }
        if (jobOpportunity.getCriterion() == null) {
            throw new IllegalArgumentException("Criterion is required");
        }
    }

    public void createJobOpportunity(IJobOpportunity jobOpportunity) {

        if(jobOpportunity.getClosingDate() == null) {
            closingDay(jobOpportunity);
        }
        jobOpportunity.setId(UUID.randomUUID().getMostSignificantBits());
        jobOpportunity.setStatus(true);

        new JobOpportunity(jobOpportunity.getId(),jobOpportunity.getTitle(), jobOpportunity.getDescription(),
                jobOpportunity.getLanguage(),jobOpportunity.getStartDate(),
                jobOpportunity.getClosingDate(), jobOpportunity.getEducationLevel(),
                jobOpportunity.getSalary(), jobOpportunity.getCriterion(),
                jobOpportunity.getCompany(), jobOpportunity.getCustomer());
    }

    private void closingDay(IJobOpportunity jobOpportunity) {
        jobOpportunity.setClosingDate(LocalDate.now().plusDays(30));
    }

    public boolean isExpired(LocalDate closingDate) {
       if(closingDate.isEqual(LocalDate.now())){
           return true;
       } else {
           return false;
       }
    }

    public boolean opportunityExists(Long id) {
        return true;
    }


}
