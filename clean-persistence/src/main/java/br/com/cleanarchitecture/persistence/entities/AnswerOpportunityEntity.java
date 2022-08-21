package br.com.cleanarchitecture.persistence.entities;

import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.User;
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
    private double minimumProfile;

    protected AnswerOpportunityEntity() {}

    public AnswerOpportunityEntity(Set<PointsEntity> pmdUser, Set<JobOpportunityEntity> jobOpportunityEntities, UserEntity userEntity,double minimumProfile) {
        this.pmdUser = pmdUser;
        this.jobOpportunityEntities = jobOpportunityEntities;
        this.userEntity = userEntity;
        this.minimumProfile = minimumProfile;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "answerOpportunityEntity")
    private Set<PointsEntity> pmdUser = new java.util.LinkedHashSet<>();

    @OneToMany(mappedBy = "answerOpportunity")
    private Set<JobOpportunityEntity> jobOpportunityEntities= new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "answer_opportunity_user_entity",
            joinColumns = @JoinColumn(name = "answer_opportunity_entity_null"),
            inverseJoinColumns = @JoinColumn(name = "user_entity_cpf"))
    @JoinColumns({
            @JoinColumn(name = "USER_ENTITY_CPF", referencedColumnName = "CPF")
    })
    private UserEntity userEntity;

}
