package br.com.cleandomain.entities;

import br.com.cleandomain.entities.ientities.IEmail;
import lombok.Data;

@Data
public class Email implements IEmail {
    private String address;

    public Email(String address) {
        if (address == null || !address.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("E-mail invalido");
        }
        this.address = address;
    }
}
