package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Cpf;
import lombok.Data;

@Data
public class CpfForm {
    private String number;

    public CpfForm(Cpf cpf) {
        this.number = cpf.getNumber();
    }

    public CpfForm() {
    }

    public Cpf convertCpfFormToCpf(String number) {
        return new Cpf(number);
    }
}
