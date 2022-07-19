package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.*;

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

    void setName(String name);

    void setLastName(String lastName);

    void setEmail(Email email);

    void setCpf(Cpf cpf);

    void setPhone(Phone phone);

    void setSchoolingLevel(SchoolingLevel schoolingLevel);

    void setSkill(Skill skill);

    void setProfessionalExperience(ProfessionalExperience professionalExperience);

    IUser listAll();

    IUser edit(ICpf cpf);

}
