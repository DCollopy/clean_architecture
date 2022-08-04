package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.persistence.entities.CnpjEntity;

public class CnpjConverter {

    public CnpjConverter(){}

    public CnpjEntity convertToCnpjEntity(String cnpj) {
        return new CnpjEntity(cnpj);
    }

    public Cnpj convertToCnpj(String cnpj) {
        return new Cnpj(cnpj);
    }
}
