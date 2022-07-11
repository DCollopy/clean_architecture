package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.IUser;
import lombok.Data;

@Data
public class User extends Profile implements IUser {
    private SchoolingLevel schoolingLevel;
    private Skill skill;
    private ProfessionalExperience professionalExperience;

    public User() {
    }

    public User(String name, String lastName, Email email, Cpf cpf, Phone phone, SchoolingLevel schoolingLevel,
                Skill skill, ProfessionalExperience professionalExperience) {
        super(name, lastName, email, cpf, phone);
        this.schoolingLevel = schoolingLevel;
        this.skill = skill;
        this.professionalExperience = professionalExperience;
    }

    public String who() {
        return getCpf().getNumber();
    }

    public String getName() {
        return getName();
    }

    public String getLastName() {
        return getLastName();
    }

    public Email getEmail() {
        return getEmail();
    }

    public Cpf getCpf() {
        return getCpf();
    }

    public Phone getPhone() {
        return getPhone();
    }

    public SchoolingLevel getSchoolingLevel() {
        return schoolingLevel;
    }

    public Skill getSkill() {
        return skill;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public void setEmail(Email email) {
        super.setEmail(email);
    }

    public void setCpf(Cpf cpf) {
        super.setCpf(cpf);
    }

    public void setPhone(Phone phone) {
        super.setPhone(phone);
    }

    public void setSchoolingLevel(SchoolingLevel schoolingLevel) {
        this.schoolingLevel = schoolingLevel;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
        this.professionalExperience = professionalExperience;
    }


}
