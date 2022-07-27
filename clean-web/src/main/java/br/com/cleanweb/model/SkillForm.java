package br.com.cleanweb.model;

import br.com.cleandomain.entities.Skill;

import lombok.Data;

@Data
public class SkillForm  {

    private String language;

    public SkillForm(Skill skill) {
        this.language = skill.getLanguage();
    }

    public SkillForm() {
    }

    public Skill convertSkillFormToSkill() {
        return new Skill(this.language);
    }
}
