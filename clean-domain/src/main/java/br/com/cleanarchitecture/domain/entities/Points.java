package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

@Data
public class Points {
    private int pmdUser;

    public Points(int pmdUser) {
        if (pmdUser < 1 || pmdUser >= 6) {
            throw new IllegalArgumentException("Invalid valor, must be between 1 and 5");
        }
        this.pmdUser = pmdUser;
    }
}
