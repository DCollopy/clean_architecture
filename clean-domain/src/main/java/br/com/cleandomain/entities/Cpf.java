package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Cpf {
    private String number;

    public Cpf(String cpf) {
        if (cpf == null || !cpf.matches("^(\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2})$"))
        {
            throw new IllegalArgumentException("CPF invalido");
        }
        this.number = cpf;
    }

}
