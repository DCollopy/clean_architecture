package br.com.cleanpersistence.converter;

import br.com.cleandomain.entities.Skill;
import br.com.cleanpersistence.entities.SkillEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SkillConverter {

    public Skill convertToSkill() {
        SkillEntity skillEntity = new SkillEntity();
        return new Skill(skillEntity.getId(), skillEntity.getLanguage());

    }
}
