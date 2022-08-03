package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "answer_opportunity")
public class AnswerOpportunityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int pmdUser;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CriterionEntity> criterion;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserEntity> user;
}
