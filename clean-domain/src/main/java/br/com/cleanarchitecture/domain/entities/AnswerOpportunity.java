package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

import java.util.Set;

@Data
public class AnswerOpportunity {

    private long id;
    private Set<Points> pmdUser;
    private User user;
    private Set<Criterion> criterion;
    private double minimumProfile;

    public AnswerOpportunity(Set<Points> pmdUser,Set<Criterion> criterion , User user) {
        if (user == null) {
            throw new IllegalArgumentException("Ops,User is required");
        }
        if(criterion == null) {
            throw new IllegalArgumentException("Ops,Criterion is required");
        }
        this.pmdUser = pmdUser;
        this.criterion = criterion;
        this.user = user;
    }
    public AnswerOpportunity(Set<Points> pmdUser,Set<Criterion> criterion, User user, double average) {
        if (user == null) {
            throw new IllegalArgumentException("Ops,User is required");
        }
        if(criterion.isEmpty()) {
            throw new IllegalArgumentException("Ops,Criterion is required");
        }
        this.pmdUser = pmdUser;
        this.criterion = criterion;
        this.user = user;
        this.minimumProfile = average;
    }
    public AnswerOpportunity(){}

    public long getId() {
        return id;
    }


    public User getUser() {
        return user;
    }


    public void setId(long id) {
        this.id = id;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public double setMinimumProfile(double minimumProfile) {
        this.minimumProfile = minimumProfile;
        return minimumProfile;
    }
}
