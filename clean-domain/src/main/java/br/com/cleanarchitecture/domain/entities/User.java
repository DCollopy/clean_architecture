package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

import java.util.Set;

@Data
public class User extends Profile{

    private String uuid;
    private final String type = "USER";
    private SchoolingLevel schoolingLevel;
    private Skill skill;
    private ProfessionalExperience professionalExperience;

    private AnswerOpportunity answerOpportunity;

    public User() {
    }

    public User(String name, String lastName, Email email, Cpf cpf, Phone phone, SchoolingLevel schoolingLevel,
                Skill skill, ProfessionalExperience professionalExperience) {
        super(name, lastName, email, cpf, phone);
        this.schoolingLevel = schoolingLevel;
        this.skill = skill;
        this.professionalExperience = professionalExperience;
    }

    public User(String name, String lastName, Email email, Cpf cpf, Phone phone) {
        super(name, lastName, email, cpf, phone);
    }

    public User(String uuid,String name, String lastName, Email email, Cpf cpf, Phone phone) {
        super(name, lastName, email, cpf, phone);
        this.uuid = uuid;
    }

    public User(AnswerOpportunity answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

    public String who() {
        return this.type;
    }

    public String getName() {
        return super.getName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public Email getEmail() {
        return super.getEmail();
    }

    public Cpf getCpf() {
        return super.getCpf();
    }

    public Phone getPhone() {
        return super.getPhone();
    }

    public SchoolingLevel getSchoolingLevel() {
        return schoolingLevel;
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


}
