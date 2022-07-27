package br.com.cleanweb.model;

import lombok.Data;

@Data
public class CpfForm {
    private String number;

    public CpfForm(Cpf cpf) {
        this.number = cpf.getNumber();
    }

    public CpfForm() {
    }

    public br.com.cleandomain.entities.Cpf convertCpfFormToCpf(){
        return new br.com.cleandomain.entities.Cpf(this.number);
    }
}
