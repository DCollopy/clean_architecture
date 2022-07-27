package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.ISkill;
import lombok.Data;

@Data
public class Skill implements ISkill {

    private long id;
    private String language;

    private User user;

    public Skill(Long id,String language) {
        if(language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Invalid language");
        }
        this.language = language;
        this.id = id;
    }

    public Skill(String language) {
        if(language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Invalid language");
        }
        this.language = language;
    }
}
