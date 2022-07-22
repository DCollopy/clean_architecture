package br.com.cleanweb.model;


import br.com.cleandomain.entities.repository.ICompany;
import lombok.Data;

@Data
public class CompanyForm {

    private String cnpj;
    private String fantasyName;

    public CompanyForm(ICompany company) {
        this.cnpj = company.getCnpj();
        this.fantasyName = company.getFantasyName();
    }
}
