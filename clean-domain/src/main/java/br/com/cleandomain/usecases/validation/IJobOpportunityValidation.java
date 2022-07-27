package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Cpf;
import br.com.cleandomain.entities.JobOpportunity;

import java.time.LocalDate;
import java.util.List;

public interface IJobOpportunityValidation {

    String validate(JobOpportunity jobOpportunity);

    JobOpportunity createJobOpportunity(JobOpportunity jobOpportunity);

    boolean opportunityExists(Long id);

    boolean isExpired(LocalDate closingDate);

    JobOpportunity deleteJobOpportunity(JobOpportunity jobOpportunity);

    List<JobOpportunity> listCustomerJobOpportunity(Cpf cpf);

    boolean exitCustomerJobOpportunity(Cpf cpf);
}
