package br.com.cleanarchitecture.persistence.service.answer;


import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.AnswerOpportunityService;
import br.com.cleanarchitecture.persistence.repository.answer.AnswerOpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceIml implements AnswerOpportunityService {

    private final AnswerOpportunityRepository answerOpportunityRepository;

    public AnswerServiceIml(AnswerOpportunityRepository answerOpportunityRepository) {
        this.answerOpportunityRepository = answerOpportunityRepository;
    }

    public void save(AnswerOpportunity answerOpportunity, String whoYou) {

    }


    public List<JobOpportunity> listAllJobOpportunity() {
        return null;
    }
}
