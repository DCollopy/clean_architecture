package br.com.cleanweb.model;

import br.com.cleandomain.entities.User;
import br.com.cleandomain.entities.repository.IProfile;
import br.com.cleandomain.entities.repository.IUser;

import java.util.Set;

public class UserForm extends ProfileForm{
    private SchoolingLevelForm schoolingLevel;

    private SkillForm skill;

    private ProfessionalExperienceForm professionalExperience;

    public UserForm() {
    }

    public UserForm(IProfile profile) {
        super(profile);
    }

    public UserForm(IUser user, IProfile profile) {
        super(profile);
        this.schoolingLevel = new SchoolingLevelForm(user.getSchoolingLevel());
        this.skill = new SkillForm(user.getSkill());
        this.professionalExperience = new ProfessionalExperienceForm(user.getProfessionalExperience());
    }

    public String who(){
        return this.who();
    }

    public SchoolingLevelForm getSchoolingLevel() {
        return schoolingLevel;
    }

    public void setSchoolingLevel(SchoolingLevelForm schoolingLevel) {
        this.schoolingLevel = schoolingLevel;
    }

    public SkillForm getSkill() {
        return skill;
    }

    public void setSkill(SkillForm skill) {
        this.skill = skill;
    }

    public ProfessionalExperienceForm getProfessionalExperience() {
        return professionalExperience;
    }

    public void setProfessionalExperience(ProfessionalExperienceForm professionalExperience) {
        this.professionalExperience = professionalExperience;
    }

    public IUser convertUserformToUserCurriculum(){
        IUser user = new User(this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(),
                new CpfForm().convertCpfFormToCpf(),
                new PhoneForm().convertPhoneFormToPhone(),
                new SchoolingLevelForm().convertSchoolingLevelFormToSchoolingLevel(),
                new SkillForm().convertSkillFormToSkill(),
                new ProfessionalExperienceForm().convertProfessionalExperienceFormToProfessionalExperience());
        return user;
    }

    public IUser convertUserformToUser(){
        IUser user = new User(this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(),
                new CpfForm().convertCpfFormToCpf(),
                new PhoneForm().convertPhoneFormToPhone());
        return user;
    }
}
