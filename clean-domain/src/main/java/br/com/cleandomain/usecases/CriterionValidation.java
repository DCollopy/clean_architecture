package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.AnswerOpportunity;
import br.com.cleandomain.entities.Criterion;
import br.com.cleandomain.entities.repository.ICriterion;
import br.com.cleandomain.usecases.validation.ICriterionValidation;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class CriterionValidation implements ICriterionValidation {

    @Override
    public String validate(ICriterion criterion) {
        String message = "";
        if (criterion.getTitle() == null) {
            return "Title is required";
        }
        if (criterion.getDescription() == null) {
            return "Description is required";
        }
        if (criterion.getPmd() < 1 || criterion.getPmd() > 5) {
            return "PMD is required";
        }
        if (criterion.getWeight() < 1 || criterion.getWeight() > 5) {
            return "Weight is required";
        }
        return message;
    }

    @Override
    public void createCriterion(ICriterion criterion) {
        if(!validate(criterion).isEmpty()) {
            new Criterion(criterion.getId(), criterion.getTitle(),
                    criterion.getDescription(), criterion.getPmd(), criterion.getWeight());
        }else {
            Logger.getLogger(CriterionValidation.class.getName()).severe("Erro ao criar critério");
        }
    }

}


