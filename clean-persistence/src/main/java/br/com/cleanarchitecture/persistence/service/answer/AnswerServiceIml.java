package br.com.cleanarchitecture.persistence.service.answer;


import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.AnswerOpportunityService;
import br.com.cleanarchitecture.persistence.converter.AnswerOpportunityConverter;
import br.com.cleanarchitecture.persistence.entities.AnswerOpportunityEntity;
import br.com.cleanarchitecture.persistence.repository.answer.AnswerOpportunityRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceIml implements AnswerOpportunityService {

    private final AnswerOpportunityRepository answerOpportunityRepository;

    private final AnswerValidationAbs answerOpportunityAbs = new AnswerValidationAbs();

    private final AnswerOpportunityConverter answerOpportunityConverter = new AnswerOpportunityConverter();

    public AnswerServiceIml(AnswerOpportunityRepository answerOpportunityRepository) {
        this.answerOpportunityRepository = answerOpportunityRepository;
    }

    public void save(AnswerOpportunity answerOpportunity, String whoYou) {
        AnswerOpportunity validation = answerOpportunityAbs.createAnswerOpportunity(answerOpportunity, whoYou);
        if(validation != null){
            AnswerOpportunityEntity answerOpportunityEntity = answerOpportunityConverter.answerOpportunityToAnswerOpportunityEntity(answerOpportunity);
            answerOpportunityRepository.save(answerOpportunityEntity);
        }
    }

}
