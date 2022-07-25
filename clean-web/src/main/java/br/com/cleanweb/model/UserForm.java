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

    public IUser toUser() {
       return new User(
                this.getName(),
                this.getLastName(),
                this.toUser().getEmail(),
                this.toUser().getCpf(),
                this.toUser().getPhone());
    }

    public IUser toUserCurriculum() {
        return new User(
                this.getName(),
                this.getLastName(),
                this.toUser().getEmail(),
                this.toUser().getCpf(),
                this.toUser().getPhone(),
                this.toUser().getSchoolingLevel(),
                this.toUser().getSkill(),
                this.toUser().getProfessionalExperience());
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
}
