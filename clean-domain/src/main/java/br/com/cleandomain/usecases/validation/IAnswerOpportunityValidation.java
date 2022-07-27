package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.AnswerOpportunity;

public interface IAnswerOpportunityValidation {
    String validate(AnswerOpportunity answerOpportunity);

    void createAnswerOpportunity(AnswerOpportunity answerOpportunity);
}
