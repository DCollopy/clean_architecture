package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import br.com.cleanarchitecture.domain.entities.Email;
import br.com.cleanarchitecture.domain.usecases.CompanyValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyValidationTest {

    protected CompanyValidTest companyValidation = new CompanyValidTest();

    public Company newCompany(){
        return new Company(new Cnpj("12345678901234"), "Company");
    }

    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class,
                        () -> companyValidation.validate(new Company(new Cnpj(null), "Oliveira")));
        assertNotNull(companyValidation.validate(new Company(new Cnpj("12345678901234"), "")));
        assertNotNull(companyValidation.validate(new Company(new Cnpj("12345678901234"), null)));
    }

    @Test
    void createCompany() {
        String whoYou = new Admin().getType();
        assertNotNull(companyValidation.createCompany(newCompany(), whoYou));
    }

    @Test
    void notCreateCompany() {
        assertThrows(IllegalArgumentException.class,
                () -> companyValidation.createCompany(newCompany(), "CUSTOMER"));
    }
}