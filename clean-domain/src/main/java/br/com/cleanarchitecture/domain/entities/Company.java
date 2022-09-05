package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Company {
    private Cnpj cnpj;
    private String fantasyName;
    private Set<Customer> customers;
    public Company(Cnpj cnpj, String fantasyName, Set<Customer> customers) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
        this.customers = customers;
    }

    public Company() {
    }

    public Company(Cnpj cnpj, String fantasyName) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
    }

    public Company(Set<Customer> customers) {
        this.customers = customers;
    }


    public String getCnpj() {
        return cnpj.getNumber();
    }

    public Cnpj getCnpjObject() {
        return cnpj;
    }


    public String getFantasyName() {
        return fantasyName;
    }


    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }


    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public Company listAllCompanies() {
        return this;
    }

    public Company deleteCompany(Cnpj cnpj) {
        return this;
    }

}
