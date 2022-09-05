package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.*;
import br.com.cleanarchitecture.persistence.entities.CnpjEntity;
import br.com.cleanarchitecture.persistence.entities.CompanyEntity;
import br.com.cleanarchitecture.persistence.entities.CustomerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyConverter {
    private final CustomerConverter customerConverter = new CustomerConverter();
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


    public Set<CompanyEntity> convertSaveToCompanySet(Company company){
        CompanyEntity entity = convertToCompanyEntity(company);
        return Stream.of(entity).collect(Collectors.toSet());
    }

    public Company convertCompanyEntitySetToCompany(Set<CompanyEntity> companyEntity){
        return convertToCompany(companyEntity.iterator().next());
    }

    public CompanyEntity convertToCompanyEntityCustomer(Company company) {
        Set<CustomerEntity> customerEntities = customerConverter.convertToCustomerSetEntity(company.getCustomers());
        return new CompanyEntity(new CnpjEntity(company.getCnpj()), company.getFantasyName(), customerEntities);
    }

}
