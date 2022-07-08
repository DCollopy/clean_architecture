package br.com.cleandomain.entities;

import lombok.Data;

@Data
public class Admin extends Profile implements br.com.cleandomain.entities.ientities.IAdmin {
    private Functional functional;

    public Admin() {}

    public Admin(String name, String lastName, Email email, Cpf cpf, Phone phone, Functional functional) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }

    @Override
    public String who() {
        return functional.getNumber();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public Email getEmail() {
        return super.getEmail();
    }

    @Override
    public Cpf getCpf() {
        return super.getCpf();
    }

    @Override
    public Phone getPhone() {
        return super.getPhone();
    }

    @Override
    public Functional getFunctional() {
        return this.functional;
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public void setEmail(Email email) {
        super.setEmail(email);
    }

    @Override
    public void setCpf(Cpf cpf) {
        super.setCpf(cpf);
    }

    @Override
    public void setPhone(Phone phone) {
        super.setPhone(phone);
    }

    @Override
    public void setFunctional(Functional functional) {
        this.functional = functional;
    }
}
