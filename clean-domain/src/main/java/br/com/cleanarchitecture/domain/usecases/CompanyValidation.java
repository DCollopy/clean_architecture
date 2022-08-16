package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import br.com.cleanarchitecture.domain.entities.Customer;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class CompanyValidation {

    public String validate(Company company) {
        String message = "";
        if(company.getCnpj() == null || company.getCnpj().isEmpty()) {
            return "Cnpj is required";
        }
        if(company.getFantasyName() == null || company.getFantasyName().isEmpty()) {
            return "Fantasy name is required";
        }
        return message;
    }

    public Company createCompany(Company company, String whoYou) {
        if(validate(company).isEmpty() && whoYou.equals("ADMIN") ) {
            return new Company(new Cnpj(company.getCnpj()), company.getFantasyName());
        }
        throw new IllegalArgumentException("Company does not create");
    }

    public Company editCompany(Company company, Cnpj cnpj, String whoYou) {
        if (cnpj.getNumber().equals(company.getCnpj()) && validate(company).isEmpty() && whoYou.equals("ADMIN")) {
            Logger.getLogger(CompanyValidation.class.getName()).info("Company edited");
            return new Company(cnpj, company.getFantasyName(), company.getCustomers());
        } else {
            throw new IllegalArgumentException("Company does not edit");
        }
    }

    public Company saveCustomer(Company company) {
        company.setCustomers(new HashSet<>(company.getCustomers()));
        return company;
    }

}
