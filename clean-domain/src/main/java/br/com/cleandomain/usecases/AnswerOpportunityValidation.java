package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.AnswerOpportunity;
import br.com.cleandomain.entities.repository.IAnswerOpportunity;
import br.com.cleandomain.usecases.validation.IAnswerOpportunityValidation;

import java.util.logging.Logger;

public class AnswerOpportunityValidation implements IAnswerOpportunityValidation {

    @Override
    public String validate(IAnswerOpportunity answerOpportunity) {
        String message = "";
        if(answerOpportunity.getPmdUser() < 1 || answerOpportunity.getPmdUser() > 5) {
            message = "PMD is required";
        }
        if(answerOpportunity.getCriterion() == null) {
            message = "Criterion is required";
        }
        if(answerOpportunity.getUser() == null) {
            message = "User is required";
        }
        return "";
    }

    @Override
    public void createAnswerOpportunity(IAnswerOpportunity answerOpportunity) {
        if(!validate(answerOpportunity).isEmpty()) {
            new AnswerOpportunity(answerOpportunity.getId(), answerOpportunity.getPmdUser(), answerOpportunity.getCriterion(), answerOpportunity.getUser());
            Logger.getLogger(AnswerOpportunityValidation.class.getName()).info("AnswerOpportunity created");
        }else {
            Logger.getLogger(AnswerOpportunityValidation.class.getName()).severe("Erro ao criar resposta");
        }
    }

}
