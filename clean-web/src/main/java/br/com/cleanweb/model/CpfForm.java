package br.com.cleanweb.model;

import br.com.cleandomain.entities.Cpf;
import br.com.cleandomain.entities.repository.ICpf;
import lombok.Data;

@Data
public class CpfForm {
    private String number;

    public CpfForm(ICpf cpf) {
        this.number = cpf.getNumber();
    }

    public CpfForm() {
    }

    public Cpf convertCpfFormToCpf(){
        return new Cpf(this.number);
    }
}
