package br.com.cleanweb.model;

import br.com.cleandomain.entities.Customer;
import br.com.cleandomain.entities.Profile;
import lombok.Data;

@Data
public class CustomerForm extends ProfileForm {
    private FunctionalForm functional;
    private CompanyForm company;

    public CustomerForm(Customer customer, Profile profile) {
        super(profile);
        this.functional = new FunctionalForm(customer.getFunctional());
        this.company = new CompanyForm(customer.getCompany());
    }

    public CustomerForm(Customer customer) {
        this.functional = new FunctionalForm(customer.getFunctional());
        this.company = new CompanyForm(customer.getCompany());
    }

    public String who(){
        return this.who();
    }
}
