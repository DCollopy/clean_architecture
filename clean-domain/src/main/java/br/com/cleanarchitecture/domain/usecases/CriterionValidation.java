package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.Criterion;

import java.util.logging.Logger;

public abstract class CriterionValidation {


    public String validate(Criterion criterion) {
        String message = "";
        if (criterion.getTitle() == null) {
            return "Title is required";
        }
        if (criterion.getDescription() == null) {
            return "Description is required";
        }
        if (criterion.getPmd() < 1 || criterion.getPmd() >= 6) {
            return "PMD is required";
        }
        if (criterion.getWeight() < 1 || criterion.getWeight() >= 6) {
            return "Weight is required";
        }
        return message;
    }


    public Criterion createCriterion(Criterion criterion) {
        if(validate(criterion).isEmpty()) {
            Logger.getLogger(CriterionValidation.class.getName()).info("Criterion created");
           return new Criterion(criterion.getTitle(),criterion.getDescription(), criterion.getPmd(), criterion.getWeight());
        }else {
            Logger.getLogger(CriterionValidation.class.getName()).severe("Erro ao criar critério");
            throw new IllegalArgumentException("Criterion not created");
        }
    }

    public Criterion editCriterion(Criterion criterion, long id) {
        if(!validate(criterion).isEmpty() && id == criterion.getId()) {
            Logger.getLogger(CriterionValidation.class.getName()).info("Criterion not edited");
            return new Criterion(criterion.getTitle(),criterion.getDescription(), criterion.getPmd(), criterion.getWeight());
        }else {
            Logger.getLogger(CriterionValidation.class.getName()).severe("Erro ao editar critério");
            throw new IllegalArgumentException("Criterion not edited");
        }
    }
}


