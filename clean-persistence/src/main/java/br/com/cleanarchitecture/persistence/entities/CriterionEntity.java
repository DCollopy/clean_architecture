package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "criterion")
public class CriterionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String title;
    @Column(length = 500)
    private String description;
    private int pmd;
    private int weight;

    protected CriterionEntity() {}
    public CriterionEntity(String title, String description, int pmd, int weight, JobOpportunityEntity jobOpportunity) {
        this.title = title;
        this.description = description;
        this.pmd = pmd;
        this.weight = weight;
        this.jobOpportunity = jobOpportunity;
    }

    public CriterionEntity(String title, String description, int pmd, int weight) {
        this.title = title;
        this.description = description;
        this.pmd = pmd;
        this.weight = weight;
    }

    public CriterionEntity(AnswerOpportunityEntity answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="job_id")
    private JobOpportunityEntity jobOpportunity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="answer_id")
    private AnswerOpportunityEntity answerOpportunity;


}
