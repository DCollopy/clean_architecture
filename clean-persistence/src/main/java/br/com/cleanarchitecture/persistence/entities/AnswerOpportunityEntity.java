package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "answerOpportunity")
public class AnswerOpportunityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int pmdUser;

    @OneToMany(mappedBy = "answerOpportunity")
    private Set<CriterionEntity> criterion = new HashSet<>();

    @OneToMany(mappedBy = "answerOpportunity")
    private Set<UserEntity> user = new HashSet<>();
}
