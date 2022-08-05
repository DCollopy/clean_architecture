package br.com.cleanarchitecture.web.model;


import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import lombok.Data;

@Data
public class CompanyForm {

    private String cnpj;
    private String fantasyName;

    public CompanyForm(Company company) {
        this.cnpj = company.getCnpj();
        this.fantasyName = company.getFantasyName();
    }

    public CompanyForm(){}

    public Company convertCompany() {
        return new Company(new Cnpj(this.getCnpj()), this.getFantasyName());
    }

    public Company convertCompanyToCompany(String cnpj, String fantasyName) {
        return new Company(new Cnpj(cnpj), fantasyName);
    }
}