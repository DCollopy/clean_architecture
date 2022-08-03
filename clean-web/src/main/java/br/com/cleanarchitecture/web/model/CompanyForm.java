package br.com.cleanarchitecture.web.model;


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
}
