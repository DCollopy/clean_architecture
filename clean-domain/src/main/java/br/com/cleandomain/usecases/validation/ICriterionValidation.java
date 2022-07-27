package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Criterion;

public interface ICriterionValidation {
    String validate(Criterion criterion);

    void createCriterion(Criterion criterion);

    // (pmd * weight) + (pmd * weight) + (pmd * weight)/ weight + weight + weight = moderateAverage

}
