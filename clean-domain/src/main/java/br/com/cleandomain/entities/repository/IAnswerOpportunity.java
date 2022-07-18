package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.Criterion;

public interface IAnswerOpportunity {
    long getId();

    int getPmdUser();

    int getWeightUser();

    Criterion getCriterion();

    void setId(long id);

    void setPmdUser(int pmdUser);

    void setWeightUser(int weightUser);

    void setCriterion(Criterion criterion);
}
