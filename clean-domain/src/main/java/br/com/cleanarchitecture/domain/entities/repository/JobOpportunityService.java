package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;

import java.util.List;

public interface JobOpportunityService {

    JobOpportunity findById(Long id);

    void save(JobOpportunity jobOpportunity, String whoYou);
    void saveAnswer(JobOpportunity jobOpportunity, AnswerOpportunity answerOpportunity);

    JobOpportunity edit(JobOpportunity jobOpportunity, long id);

    boolean isExpiredDay(JobOpportunity jobOpportunity);

    List<JobOpportunity> findAll();

    JobOpportunity findCustomerOpportunity(JobOpportunity jobOpportunity);

    JobOpportunity findJob(long id);

    boolean exists(JobOpportunity jobOpportunity);

    void delete(JobOpportunity jobOpportunity, Cpf cpf);



}
