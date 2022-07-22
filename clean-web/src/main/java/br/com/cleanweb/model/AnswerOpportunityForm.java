package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.IAnswerOpportunity;
import lombok.Data;

@Data
public class AnswerOpportunityForm {

    private long id;
    private int pmdUser;
    private int weightUser;
    private CriterionForm criterion;

    public AnswerOpportunityForm(IAnswerOpportunity answerOpportunity) {
        this.id = answerOpportunity.getId();
        this.pmdUser = answerOpportunity.getPmdUser();
        this.criterion = new CriterionForm(answerOpportunity.getCriterion());
    }

}
