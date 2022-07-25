package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.IProfile;
import lombok.Data;

@Data
public abstract class Profile implements IProfile {
    private String name;
    private String lastName;
    private Email email;
    private Cpf cpf;
    private Phone phone;

    public Profile(String name, String lastName, Email email, Cpf cpf, Phone phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
    }

    public Profile() {}


}

