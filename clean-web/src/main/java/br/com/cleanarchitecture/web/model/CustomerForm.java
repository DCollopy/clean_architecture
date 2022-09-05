package br.com.cleanarchitecture.web.model;


import br.com.cleanarchitecture.domain.entities.Customer;

import lombok.Data;

@Data
public class CustomerForm{

    private String uuid;
    private String name;
    private String lastName;

    private String email;

    private String cpf;

    private String ddd;

    private String phone;

    private String functional;

    private String cnpj;

    private final String type = "CUSTOMER";

    public CustomerForm(){}

    public String who(){
        return this.getType();
    }

    public Customer convertCustomer(){
        return new Customer(this.getUuid(),this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(this.getEmail()),
                new CpfForm().convertCpfFormToCpf(this.getCpf()),
                new PhoneForm().convertPhoneFormToPhone(this.getDdd(), this.getPhone()),
                new FunctionalForm().convertFunctionalToFunctional(this.getFunctional()));
    }
}
