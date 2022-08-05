package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Profile;
import br.com.cleanarchitecture.domain.entities.User;
import lombok.Data;

@Data
public class UserForm extends ProfileForm{
    private SchoolingLevelForm schoolingLevel;

    private SkillForm skill;

    private ProfessionalExperienceForm professionalExperience;

    private final String type = "USER";

    public UserForm() {}

    public UserForm(Profile profile) {
        super(profile);
    }

    public UserForm(User user, Profile profile) {
        super(profile);
        this.schoolingLevel = new SchoolingLevelForm(user.getSchoolingLevel());
        this.skill = new SkillForm(user.getSkill());
        this.professionalExperience = new ProfessionalExperienceForm(user.getProfessionalExperience());
    }

    public String who() {
        return this.getType();
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

    public User convertUserformToUserCurriculum(){
        User user = new User(this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(this.getEmail().getAddress()),
                new CpfForm().convertCpfFormToCpf(this.getCpf().getNumber()),
                new PhoneForm().convertPhoneFormToPhone(this.getPhone().getDdd(), this.getPhone().getNumber()),
                new SchoolingLevelForm().convertSchoolingLevelFormToSchoolingLevel(),
                new SkillForm().convertSkillFormToSkill(this.getSkill().getLanguage()),
                new ProfessionalExperienceForm().convertProfessionalExperienceFormToProfessionalExperience());
        return user;
    }

    public User convertUserformToUser(){
        User user = new User(this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(this.getEmail().getAddress()),
                new CpfForm().convertCpfFormToCpf(this.getCpf().getNumber()),
                new PhoneForm().convertPhoneFormToPhone(this.getPhone().getDdd(), this.getPhone().getNumber()));
        return user;
    }
}
