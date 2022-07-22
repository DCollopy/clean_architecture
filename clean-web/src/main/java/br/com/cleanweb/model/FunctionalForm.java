package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.IFunctional;
import lombok.Data;

@Data
public class FunctionalForm {
    private String number;

    public FunctionalForm(IFunctional functional) {
        this.number = functional.getNumber();
    }

}
