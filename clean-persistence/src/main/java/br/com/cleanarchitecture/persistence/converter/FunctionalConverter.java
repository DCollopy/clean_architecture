package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Functional;
import br.com.cleanarchitecture.persistence.entities.FunctionalEntity;

public class FunctionalConverter {

    public FunctionalConverter(){}

    public FunctionalEntity convertToFunctionalEntity(String functional) {
        return new FunctionalEntity(functional);
    }

    public Functional convertToFunctional(String functional) {
        return new Functional(functional);
    }
}
