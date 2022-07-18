package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.repository.IJobOpportunity;

import java.time.LocalDate;

public interface IJobOpportunityValidation {

    void validate(IJobOpportunity jobOpportunity);

    void createJobOpportunity(IJobOpportunity jobOpportunity);

    boolean opportunityExists(Long id);

    boolean isExpired(LocalDate closingDate);
}
