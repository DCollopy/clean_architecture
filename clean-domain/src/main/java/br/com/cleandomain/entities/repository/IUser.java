package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.*;

import java.util.Set;

public interface IUser {
    String who();

    String getName();

    String getLastName();

    Email getEmail();

    Cpf getCpf();

    Phone getPhone();

    SchoolingLevel getSchoolingLevel();

    Skill getSkill();

    ProfessionalExperience getProfessionalExperience();

    Set<AnswerOpportunity> getAnswerOpportunity();

    void setName(String name);

    void setLastName(String lastName);

    void setEmail(Email email);

    void setCpf(Cpf cpf);

    void setPhone(Phone phone);

    void setSchoolingLevel(SchoolingLevel schoolingLevel);

    void setSkill(Skill skill);

    void setProfessionalExperience(ProfessionalExperience professionalExperience);

    void setAnswerOpportunity(Set<AnswerOpportunity> answerOpportunity);

    IUser listAll();

    IUser edit(ICpf cpf);

}
