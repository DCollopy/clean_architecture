package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.Profile;
import lombok.Data;

@Data
public class CustomerForm extends ProfileForm {
    private FunctionalForm functional;
    private CompanyForm company;

    private final String type = "CUSTOMER";

    public CustomerForm(){}
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
        return this.getType();
    }

    public Customer convertCustomer(){
        return new Customer(this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(this.getEmail().getAddress()),
                new CpfForm().convertCpfFormToCpf(this.getCpf().getNumber()),
                new PhoneForm().convertPhoneFormToPhone(this.getPhone().getDdd(), this.getPhone().getNumber()),
                new FunctionalForm().convertFunctionalToFunctional(this.getFunctional().getNumber()),
                new CompanyForm().convertCompanyToCompany(this.getCompany().getCnpj(), this.getCompany().getFantasyName()));
    }
}
