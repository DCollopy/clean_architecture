package br.com.cleanweb.model;


import br.com.cleandomain.entities.Company;
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
