package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.repository.IAnswerOpportunity;

public interface IAnswerOpportunityValidation {
    String validate(IAnswerOpportunity answerOpportunity);

    void createAnswerOpportunity(IAnswerOpportunity answerOpportunity);
}
