package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import lombok.Data;

@Data
public class AnswerOpportunityForm {

    private long id;
    private int pmdUser;
    private int weightUser;
    private CriterionForm criterion;

    public AnswerOpportunityForm(AnswerOpportunity answerOpportunity) {
        this.id = answerOpportunity.getId();
        this.pmdUser = answerOpportunity.getPmdUser();
        this.criterion = new CriterionForm(answerOpportunity.getCriterion());
    }

}
