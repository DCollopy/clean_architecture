package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.Criterion;
import br.com.cleandomain.entities.User;

public interface IAnswerOpportunity {
    long getId();

    int getPmdUser();

    Criterion getCriterion();

    User getUser();
    void setId(long id);

    void setPmdUser(int pmdUser);


    void setCriterion(Criterion criterion);
    void setUser(User user);
}
