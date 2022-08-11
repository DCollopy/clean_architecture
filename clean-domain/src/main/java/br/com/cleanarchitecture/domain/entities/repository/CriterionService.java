package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Criterion;

public interface CriterionService {

    void save(Criterion criterion);

    Criterion edit(Criterion criterion, long id);

    Criterion findOne(long id);

    public Boolean exist(long id);

}
