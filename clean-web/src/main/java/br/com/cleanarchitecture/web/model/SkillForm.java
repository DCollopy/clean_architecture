package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Skill;

import lombok.Data;

@Data
public class SkillForm  {

    private String language;

    public SkillForm(Skill skill) {
        this.language = skill.getLanguage();
    }

    public SkillForm() {
    }


    public Skill convertSkillFormToSkill(String language) {
        return new Skill(language);
    }
}
