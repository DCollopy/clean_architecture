package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Client extends Profile {
    private String functional;

    public String how() {
        return functional;
    }
}
