package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.AnswerOpportunity;
import br.com.cleandomain.entities.JobOpportunity;

import java.util.Set;

public interface ICriterion {

    long getId();
    String getTitle();

    String getDescription();

    int getPmd();

    int getWeight();

    JobOpportunity getJobOpportunity();
    Set<AnswerOpportunity> getAnswerOpportunity();

    void setTitle(String title);

    void setDescription(String description);

    void setPmd(int pmd);

    void setWeight(int weight);

    void setId(long id);

    void setAnswerOpportunity(Set<AnswerOpportunity> answerOpportunity);

    void setJobOpportunity(JobOpportunity jobOpportunity);
}
