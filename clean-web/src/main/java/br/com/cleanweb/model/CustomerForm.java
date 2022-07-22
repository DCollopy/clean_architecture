package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.ICustomer;
import br.com.cleandomain.entities.repository.IProfile;
import lombok.Data;

@Data
public class CustomerForm extends ProfileForm {
    private FunctionalForm functional;
    private CompanyForm company;

    public CustomerForm(ICustomer customer, IProfile profile) {
        super(profile);
        this.functional = new FunctionalForm(customer.getFunctional());
        this.company = new CompanyForm(customer.getCompany());
    }

    public CustomerForm(ICustomer customer) {
        this.functional = new FunctionalForm(customer.getFunctional());
        this.company = new CompanyForm(customer.getCompany());
    }

    public String who(){
        return this.who();
    }
}
