package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;

import java.util.logging.Logger;

public abstract class AnswerOpportunityValidation  {


    public String validate(AnswerOpportunity answerOpportunity) {
        if(answerOpportunity.getPmdUser() < 1 || answerOpportunity.getPmdUser() > 5) {
            return  "PMD is required";
        }
        if(answerOpportunity.getCriterion() == null) {
            return "Criterion is required";
        }
        if(answerOpportunity.getUser() == null) {
            return "User is required";
        }
        return "";
    }


    public void createAnswerOpportunity(AnswerOpportunity answerOpportunity) {
        if(!validate(answerOpportunity).isEmpty()) {
            new AnswerOpportunity(answerOpportunity.getId(), answerOpportunity.getPmdUser(), answerOpportunity.getCriterion(), answerOpportunity.getUser());
            Logger.getLogger(AnswerOpportunityValidation.class.getName()).info("AnswerOpportunity created");
        }else {
            Logger.getLogger(AnswerOpportunityValidation.class.getName()).severe("Erro ao criar resposta");
        }
    }

}
