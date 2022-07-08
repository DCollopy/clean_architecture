package br.com.cleandomain.entities;

import br.com.cleandomain.entities.ientities.IClient;
import lombok.Data;


@Data
public class Client extends Profile implements IClient {
    private Functional functional;

    public Client() {}

    public Client(String name, String lastName, Email email, Cpf cpf, Phone phone, Functional functional) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }


    public String who() {
        return functional.getNumber();
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



}
