package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.ISkill;
import lombok.Data;

@Data
public class SkillForm {

    private String language;

    public SkillForm(ISkill skill) {
        this.language = skill.getLanguage();
    }
}