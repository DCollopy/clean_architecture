package br.com.cleanweb.model;

import br.com.cleandomain.entities.AnswerOpportunity;
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
