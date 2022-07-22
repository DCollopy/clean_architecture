package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.ISkill;
import lombok.Data;

@Data
public class Skill implements ISkill {
    private String language;

    public Skill(String language) {
        if(language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Invalid language");
        }
        this.language = language;
    }
}
