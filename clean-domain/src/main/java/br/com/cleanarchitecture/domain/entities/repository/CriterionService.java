package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;

import java.util.List;
import java.util.Set;

public interface CriterionService {

    void save(Set<Criterion> criterion, JobOpportunity jobOpportunity);

    Criterion edit(Criterion criterion, long id);

    Criterion findOne(long id);

    List<Criterion> findJob(long id);

    List<Criterion> findAll();

    public Boolean exist(long id);

}
