package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;

import java.util.List;

public interface AnswerOpportunityService {

    void save(AnswerOpportunity answerOpportunity, String whoYou);

    List<JobOpportunity> listAllJobOpportunity();

}
