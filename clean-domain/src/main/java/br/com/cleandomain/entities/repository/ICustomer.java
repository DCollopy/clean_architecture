package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.*;

public interface ICustomer {
    String who();

    String getName();

    String getLastName();

    Email getEmail();

    Cpf getCpf();

    Phone getPhone();

    Functional getFunctional();

    Company getCompany();

    void setName(String name);

    void setLastName(String lastName);

    void setEmail(Email email);

    void setCpf(Cpf cpf);

    void setPhone(Phone phone);

    void setFunctional(Functional functional);

    void setCompany(Company company);


}
