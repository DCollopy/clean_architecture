package br.com.cleanarchitecture.domain.entities;

import lombok.Data;


@Data
public class Customer extends Profile{
    private Functional functional;

    private final String type = "CUSTOMER";
    private Company company;

    public Customer() {}

    public Customer(String name, String lastName, Email email, Cpf cpf,
                    Phone phone, Functional functional, Company company) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
        this.company = company;
    }

    public String who() {
        return "CUSTOMER";
    }

    public String getName() {
        return super.getName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public Email getEmail() {
        return super.getEmail();
    }

    public Cpf getCpf() {
        return super.getCpf();
    }

    public Phone getPhone() {
        return super.getPhone();
    }

    public Functional getFunctional() {
        return this.functional;
    }

    public Company getCompany() {
        return this.company;
    }

    public String getCompanyCnpj() {
        return this.company.getCnpj();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public void setEmail(Email email) {
        super.setEmail(email);
    }

    public void setCpf(Cpf cpf) {
        super.setCpf(cpf);
    }

    public void setPhone(Phone phone) {
        super.setPhone(phone);
    }

    public void setFunctional(Functional functional) {
        this.functional = functional;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer listAll(){
        return this;
    }

    public Customer delete(long id){
        return this;
    }

}
