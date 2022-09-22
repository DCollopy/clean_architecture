package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Profile;
import br.com.cleanarchitecture.domain.entities.User;
import lombok.Data;

@Data
public class UserForm {

    private String uuid;

    private String name;

    private String lastName;

    private String email;

    private String cpf;

    private String ddd;

    private String phone;
    private SchoolingLevelForm schoolingLevel;
    private SkillForm skill;
    private ProfessionalExperienceForm professionalExperience;


    private final String type = "USER";

    public UserForm() {}

    public UserForm(User user) {
        this.uuid = user.getUuid();
        this.schoolingLevel = new SchoolingLevelForm(user.getSchoolingLevel());
        this.skill = new SkillForm(user.getSkill());
        this.professionalExperience = new ProfessionalExperienceForm(user.getProfessionalExperience());
    }

    public String who() {
        return this.getType();
    }

    public User convertUserformToUserCurriculum(){
        User user = new User(this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(this.getEmail()),
                new CpfForm().convertCpfFormToCpf(this.getCpf()),
                new PhoneForm().convertPhoneFormToPhone(this.getDdd(), this.getPhone()),
                new SchoolingLevelForm().convertSchoolingLevelFormToSchoolingLevel(),
                new SkillForm().convertSkillFormToSkill(this.getSkill().getLanguage()),
                new ProfessionalExperienceForm().convertProfessionalExperienceFormToProfessionalExperience());
        return user;
    }

    public User convertUserformToUser(){
        User user = new User(this.getUuid(),this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(this.getEmail()),
                new CpfForm().convertCpfFormToCpf(this.getCpf()),
                new PhoneForm().convertPhoneFormToPhone(this.getDdd(), this.getPhone()));
        return user;
    }

    public User convertToUser(User user){
         return new User(user.getUuid(),user.getName(), user.getLastName(),
                new EmailForm().convertEmailFormToEmail(user.getEmail().getAddress()),
                new CpfForm().convertCpfFormToCpf(user.getCpf().getNumber()),
                new PhoneForm().convertPhoneFormToPhone(user.getPhone().getDdd(), user.getPhone().getNumber()));
    }
}
