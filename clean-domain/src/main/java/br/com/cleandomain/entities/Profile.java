package br.com.cleandomain.entities;

import lombok.Data;

@Data
public abstract class Profile {
    private String name;
    private String lastName;
    private String email;
    private Cpf cpf;
    private Phone phone;

    public abstract String how();
}
