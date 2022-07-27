package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Company {
    private Cnpj cnpj;
    private String fantasyName;

    public Company() {
    }

    public Company(Cnpj cnpj, String fantasyName) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
    }


    public String getCnpj() {
        return cnpj.getNumber();
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
