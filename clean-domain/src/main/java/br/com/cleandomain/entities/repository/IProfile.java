package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.Cpf;
import br.com.cleandomain.entities.Email;
import br.com.cleandomain.entities.Phone;

public interface IProfile {
    String who();

    String getName();

    String getLastName();

    Email getEmail();

    Cpf getCpf();

    Phone getPhone();

    void setName(String name);

    void setLastName(String lastName);

    void setEmail(Email email);

    void setCpf(Cpf cpf);

    void setPhone(Phone phone);
}
