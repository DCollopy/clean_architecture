package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.IAnswerOpportunity;

public class AnswerOpportunity implements IAnswerOpportunity {

    private long id;
    private int pmdUser;
    private int weightUser;

    private Criterion criterion;

    public AnswerOpportunity(long id,int pmdUser, int weightUser) {
        if(pmdUser <=1 || pmdUser >= 6){
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if(weightUser <=1 || weightUser >= 6){
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        this.pmdUser = pmdUser;
        this.weightUser = weightUser;
    }

    public AnswerOpportunity(long id, int pmdUser, int weightUser, Criterion criterion) {
        this.id = id;
        this.pmdUser = pmdUser;
        this.weightUser = weightUser;
        this.criterion = criterion;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public int getPmdUser() {
        return pmdUser;
    }

    @Override
    public int getWeightUser() {
        return weightUser;
    }

    @Override
    public Criterion getCriterion() {
        return criterion;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setPmdUser(int pmdUser) {
        this.pmdUser = pmdUser;
    }

    @Override
    public void setWeightUser(int weightUser) {
        this.weightUser = weightUser;
    }

    @Override
    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }
}
