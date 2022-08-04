package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

@Data
public abstract class Profile{
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

    public abstract String who();

}

