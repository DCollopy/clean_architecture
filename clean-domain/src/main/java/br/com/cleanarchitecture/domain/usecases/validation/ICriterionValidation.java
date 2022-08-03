package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.Criterion;

public interface ICriterionValidation {
    String validate(Criterion criterion);

    void createCriterion(Criterion criterion);

    // (pmd * weight) + (pmd * weight) + (pmd * weight)/ weight + weight + weight = moderateAverage

}
