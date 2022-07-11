package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Skill {
    private String language;

    public Skill(String language) {
        if(language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Invalid language");
        }
        this.language = language;
    }
}
