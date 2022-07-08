package br.com.cleandomain.entities;

import br.com.cleandomain.entities.ientities.IUser;
import lombok.Data;

@Data
public class User extends Profile implements IUser {
    private SchoolingLevel schoolingLevel;
    private Skill skill;
    private ProfessionalExperience  professionalExperience;

    public String who() {
        return getCpf().getNumber();
    }
}
