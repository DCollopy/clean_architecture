package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.ICompany;
import lombok.Data;

@Data
public class Company implements ICompany {
    private Cnpj cnpj;
    private String fantasyName;

    public Company() {}
    public Company(Cnpj cnpj, String fantasyName) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
    }

    @Override
    public String getCnpj() {
        return cnpj.getNumber();
    }

    @Override
    public String getFantasyName() {
        return fantasyName;
    }

    @Override
    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }

    @Override
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
