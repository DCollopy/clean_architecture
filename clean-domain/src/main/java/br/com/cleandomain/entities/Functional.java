package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Functional {
    private String number;

    public Functional(String number) {
        if (!number.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Numero invalido!");
        }
        this.number = number;
    }
}
