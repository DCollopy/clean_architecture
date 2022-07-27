package br.com.cleandomain.entities;

public class AnswerOpportunity {

    private long id;
    private int pmdUser;
    private Criterion criterion;
    private User user;

    public AnswerOpportunity(long id, int pmdUser, Criterion criterion, User user) {
        if (pmdUser < 1 || pmdUser >= 6) {
            throw new IllegalArgumentException("Valor Incorreto, entre com um valor de 1 a 5 ");
        }
        if (criterion == null) {
            throw new IllegalArgumentException("Criterio não pode ser nulo");
        }
        if (user == null) {
            throw new IllegalArgumentException("Usuario não pode ser nulo");
        }
        this.id = id;
        this.criterion = criterion;
        this.user = user;
        this.pmdUser = pmdUser;
    }


    public long getId() {
        return id;
    }


    public int getPmdUser() {
        return pmdUser;
    }


    public Criterion getCriterion() {
        return criterion;
    }

    public User getUser() {
        return user;
    }


    public void setId(long id) {
        this.id = id;
    }


    public void setPmdUser(int pmdUser) {
        this.pmdUser = pmdUser;
    }


    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
