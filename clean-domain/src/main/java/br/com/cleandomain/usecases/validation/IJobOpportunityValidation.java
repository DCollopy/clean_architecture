package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.repository.ICpf;
import br.com.cleandomain.entities.repository.IJobOpportunity;

import java.time.LocalDate;
import java.util.List;

public interface IJobOpportunityValidation {

    String validate(IJobOpportunity jobOpportunity);

    void createJobOpportunity(IJobOpportunity jobOpportunity);

    boolean opportunityExists(Long id);

    boolean isExpired(LocalDate closingDate);

    void deleteJobOpportunity(IJobOpportunity jobOpportunity);

    List<IJobOpportunity> listCustomerJobOpportunity(ICpf cpf);

    boolean exitCustomerJobOpportunity(ICpf cpf);
}
