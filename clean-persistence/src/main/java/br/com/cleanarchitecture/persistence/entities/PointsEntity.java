package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "points")
public class PointsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int pmdUser;

    protected PointsEntity() {}

    public PointsEntity(int pmdUser) {
        this.pmdUser = pmdUser;
    }
    @ManyToOne
    @JoinColumn(name = "answer_opportunity_id")
    private AnswerOpportunityEntity answerOpportunityEntity;

}