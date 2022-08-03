package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Skill;

public class SkillConverter {

    public SkillConverter() {
    }

    public Skill convertToSkill(String language) {
        return new Skill(language);

    }
}
