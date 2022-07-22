package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.repository.ICriterion;

public interface ICriterionValidation {
    String validate(ICriterion criterion);

    void createCriterion(ICriterion criterion);

    // (pmd * weight) + (pmd * weight) + (pmd * weight)/ weight + weight + weight = moderateAverage

}
