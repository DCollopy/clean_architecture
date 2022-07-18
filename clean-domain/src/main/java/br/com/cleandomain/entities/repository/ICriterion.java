package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.AnswerOpportunity;

public interface ICriterion {

    long getId();
    String getTitle();

    String getDescription();

    int getPmd();

    int getWeight();

    AnswerOpportunity getAnswerOpportunity();

    void setTitle(String title);

    void setDescription(String description);

    void setPmd(int pmd);

    void setWeight(int weight);

    void setId(long id);

    void setAnswerOpportunity(AnswerOpportunity answerOpportunity);

}
