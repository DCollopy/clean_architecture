package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Cnpj {
    private String number;

    public Cnpj(String number) {
        if (number == null || !number.matches("^(\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}-?\\d{2})$"))
        {
            throw new IllegalArgumentException("CNPJ invalido");
        }
        this.number = number;
    }

}

