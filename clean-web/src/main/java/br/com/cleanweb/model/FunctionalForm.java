package br.com.cleanweb.model;

import br.com.cleandomain.entities.Functional;
import lombok.Data;

@Data
public class FunctionalForm {
    private String number;

    public FunctionalForm(Functional functional) {
        this.number = functional.getNumber();
    }

}
