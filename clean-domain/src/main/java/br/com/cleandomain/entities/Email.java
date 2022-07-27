package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Email  {
    private String address;

    public Email(String address) {
        if (address == null || !address.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("E-mail invalido");
        }
        this.address = address;
    }
}
