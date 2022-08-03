package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;

public interface IAnswerOpportunityValidation {
    String validate(AnswerOpportunity answerOpportunity);

    void createAnswerOpportunity(AnswerOpportunity answerOpportunity);
}
