package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;

import java.util.Set;

public abstract class CompanyValidation {

    private AdminValidation adminValidation;
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

    public Company createCompany(Company company, Admin admin) {
        if(validate(company).isEmpty() && adminValidation.adminIsAdmin(admin) ) {
            return new Company(new Cnpj(company.getCnpj()), company.getFantasyName());
        }
        throw new IllegalArgumentException("Company does not create");
    }

}
