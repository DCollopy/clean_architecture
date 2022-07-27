package br.com.cleanpersistence.entities;

import br.com.cleandomain.entities.Cpf;
import br.com.cleandomain.entities.Email;
import br.com.cleandomain.entities.Phone;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class UserEntity extends ProfileEntity implements Serializable {

    public UserEntity() {
    }
    public UserEntity(String name, String lastName, Email convertToEmail, Cpf convertToCpf, Phone convertToPhone) {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private SchoolingLevelEntity schoolingLevel;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "skill_user")
    private Set<SkillEntity> skill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professionalExperience_id")
    private ProfessionalExperienceEntity professional_experience_user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "answer_opportunity_user")
    private AnswerOpportunityEntity answerOpportunity;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "job_opportunity_user")
    private Set<JobOpportunityEntity> jobOpportunity;

}
