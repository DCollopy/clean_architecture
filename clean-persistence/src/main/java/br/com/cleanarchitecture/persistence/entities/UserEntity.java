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
    public UserEntity() {
    }

    public UserEntity(String name, String lastName, EmailEntity email, CpfEntity cpf, PhoneEntity phone) {
        super(name, lastName,email,cpf,phone);
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private SchoolingLevelEntity schoolingLevel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_user")
    private Set<SkillEntity> skill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professionalExperience")
    private ProfessionalExperienceEntity professionalExperience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answerOopportunity_user")
    private AnswerOpportunityEntity answerOpportunity;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<JobOpportunityEntity> jobOpportunity = new HashSet<>();

}
