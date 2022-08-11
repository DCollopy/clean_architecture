package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

import java.util.Set;

@Data
public class Criterion  {
    private Long id;
    private String title;
    private String description;
    private int pmd;
    private int weight;
    private Set<AnswerOpportunity> answerOpportunity;


    public Criterion(String title, String description, int pmd, int weight) {
        if (pmd < 1 || pmd >= 6) {
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if (weight < 1 || weight >= 6) {
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Entre com o titulo!");
        }
        this.pmd = pmd;
        this.weight = weight;
        this.title = title;
        this.description = description;
    }

    public Criterion(long id,String title, String description, int pmd, int weight) {
        if (pmd < 1 || pmd >= 6) {
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if (weight < 1 || weight >= 6) {
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Entre com o titulo!");
        }
        this.id = id;
        this.pmd = pmd;
        this.weight = weight;
        this.title = title;
        this.description = description;
    }

    public Criterion(Set<AnswerOpportunity> answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

    public Criterion() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPmd() {
        return pmd;
    }

    public int getWeight() {
        return weight;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPmd(int pmd) {
        this.pmd = pmd;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<AnswerOpportunity> getAnswerOpportunity() {
        return answerOpportunity;
    }
    public void setAnswerOpportunity(Set<AnswerOpportunity> answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

}
