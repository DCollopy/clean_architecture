package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import br.com.cleanarchitecture.persistence.entities.CnpjEntity;
import br.com.cleanarchitecture.persistence.entities.CompanyEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class CompanyConverter {

    public CompanyConverter(){}

    public CompanyEntity convertToCompanyEntity(String cnpj, String fantasyName) {
        return new CompanyEntity(new CnpjEntity(cnpj), fantasyName);
    }

    public Company convertToCompany(String cnpj, String fantasyName) {
        return new Company(new Cnpj(cnpj),fantasyName);
    }
}
