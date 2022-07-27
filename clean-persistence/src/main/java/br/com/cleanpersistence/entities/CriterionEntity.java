package br.com.cleanpersistence.entities;

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

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<JobOpportunityEntity> jobOpportunity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private AnswerOpportunityEntity answerOpportunity;

}
