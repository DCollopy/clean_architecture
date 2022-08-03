package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.usecases.validation.ICriterionValidation;

import java.util.logging.Logger;

public class CriterionValidation implements ICriterionValidation {

    @Override
    public String validate(Criterion criterion) {
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
    public void createCriterion(Criterion criterion) {
        if(!validate(criterion).isEmpty()) {
            new Criterion(criterion.getId(), criterion.getTitle(),
                    criterion.getDescription(), criterion.getPmd(), criterion.getWeight());
        }else {
            Logger.getLogger(CriterionValidation.class.getName()).severe("Erro ao criar critério");
        }
    }

}


