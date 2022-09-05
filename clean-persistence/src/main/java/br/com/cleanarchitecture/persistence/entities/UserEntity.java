package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class UserEntity extends ProfileEntity implements Serializable {

    private final String type = "USER";

    @Column(length = 500)
    private String uuid;
    public UserEntity() {
    }

    public UserEntity(String uuid,String name, String lastName, EmailEntity email, CpfEntity cpf, PhoneEntity phone) {
        super(name, lastName,email,cpf,phone);
        this.uuid = uuid;
    }

    public UserEntity(AnswerOpportunityEntity answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private SchoolingLevelEntity schoolingLevel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_user")
    private Set<SkillEntity> skill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professionalExperience")
    private ProfessionalExperienceEntity professionalExperience;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "user_answer_opportunity_entity",
            joinColumns = @JoinColumn(name = "user_cpf"),
            inverseJoinColumns = @JoinColumn(name = "answer_opportunity_entity_id"))
    private AnswerOpportunityEntity answerOpportunity;

}
