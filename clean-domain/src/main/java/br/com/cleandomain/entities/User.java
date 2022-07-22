package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.ICpf;
import br.com.cleandomain.entities.repository.IUser;
import lombok.Data;

import java.util.Set;

@Data
public class User extends Profile implements IUser {
    private SchoolingLevel schoolingLevel;
    private Skill skill;
    private ProfessionalExperience professionalExperience;

    private Set<AnswerOpportunity> answerOpportunity;

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

    public User(Set<AnswerOpportunity> answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

    public String who() {
        return getCpf().getNumber();
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

    public Skill getSkill() {
        return skill;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public Set<AnswerOpportunity> getAnswerOpportunity() {
        return answerOpportunity;
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
    public void setAnswerOpportunity(Set<AnswerOpportunity> answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

    public User listAll(){
        return this;
    }

    public User edit(ICpf cpf){
        return this;
    }


}
