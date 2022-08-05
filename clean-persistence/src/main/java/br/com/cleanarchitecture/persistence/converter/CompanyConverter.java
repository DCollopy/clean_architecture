package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import br.com.cleanarchitecture.persistence.entities.CnpjEntity;
import br.com.cleanarchitecture.persistence.entities.CompanyEntity;

import java.util.ArrayList;
import java.util.List;

public class CompanyConverter {

    public CompanyConverter(){}

    public CompanyEntity convertToCompanyEntity(Company company) {
        return new CompanyEntity(new CnpjEntity(company.getCnpj()), company.getFantasyName());
    }

    public Company convertToCompany(CompanyEntity companyEntity) {
        return new Company(new Cnpj(companyEntity.getCnpj().getCnpj()), companyEntity.getFantasyName());
    }

    public List<Company> convertToCompanyList(List<CompanyEntity> companyEntity) {
        List<Company> companies = new ArrayList<>(companyEntity.stream().
                map(this::convertToCompany).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
        return companies;
    }
}
