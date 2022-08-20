package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

import java.util.Set;

@Data
public class AnswerOpportunity {

    private long id;
    private Set<Integer> pmdUser;
    private User user;
    private Set<JobOpportunity> jobOpportunity;
    private double minimumProfile;

    public AnswerOpportunity(Set<Integer> pmdUser, Set<JobOpportunity> jobOpportunity,User user) {
        if (pmdUser.stream().iterator().next() < 1 || pmdUser.stream().iterator().next() >= 6) {
            throw new IllegalArgumentException("Invalid valor, must be between 1 and 5");
        }
        if (user == null) {
            throw new IllegalArgumentException("Ops,User is required");
        }
        this.pmdUser = pmdUser;
        this.jobOpportunity = jobOpportunity;
        this.user = user;
    }
    public AnswerOpportunity(Set<Integer> pmdUser, Set<JobOpportunity> jobOpportunity, User user, double average) {
        if (pmdUser.stream().iterator().next() < 1 || pmdUser.stream().iterator().next() >= 6) {
            throw new IllegalArgumentException("Invalid valor, must be between 1 and 5");
        }
        if (user == null) {
            throw new IllegalArgumentException("Ops,User is required");
        }
        this.pmdUser = pmdUser;
        this.jobOpportunity = jobOpportunity;
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
