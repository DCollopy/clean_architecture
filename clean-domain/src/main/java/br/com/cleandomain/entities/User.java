package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class User extends Profile {
    private SchoolingLevel schoolingLevel;
    private Skill skill;
    private ProfessionalExperience  professionalExperience;

    public String how() {
        return getCpf().getNumber();
    }
}
