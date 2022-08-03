package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Functional;
import lombok.Data;

@Data
public class FunctionalForm {
    private String number;

    public FunctionalForm(Functional functional) {
        this.number = functional.getNumber();
    }

}
