package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;

import java.util.List;

public interface JobOpportunityService {

    JobOpportunity findById(Long id);

    void save(JobOpportunity jobOpportunity, String whoYou);

    JobOpportunity edit(JobOpportunity jobOpportunity, long id);

    boolean isExpiredDay(JobOpportunity jobOpportunity);

    List<JobOpportunity> findAllCustomerOpportunity(Cpf cpf);

    void delete(JobOpportunity jobOpportunity, Cpf cpf);



}
