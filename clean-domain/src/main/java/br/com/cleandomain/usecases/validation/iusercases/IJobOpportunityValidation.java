package br.com.cleandomain.usecases.validation.iusercases;

import br.com.cleandomain.entities.JobOpportunity;

public interface IJobOpportunityValidation {

    void validate(JobOpportunity jobOpportunity);

    boolean opportunityExists(String id);

    boolean isExpired(boolean status, String closingDate);
}
