package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

@Data
public class Admin extends Profile {

    private String uuid;
    private Functional functional;
    private final String type = "ADMIN";
    public Admin() {}

    public Admin(String name, String lastName, Email email, Cpf cpf, Phone phone, Functional functional) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }

    public Admin(String uuid,String name, String lastName, Email email, Cpf cpf, Phone phone, Functional functional) {
        super(name, lastName, email, cpf, phone);
        this.uuid = uuid;
        this.functional = functional;
    }

    public String who() {
        return this.getType();
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
}
