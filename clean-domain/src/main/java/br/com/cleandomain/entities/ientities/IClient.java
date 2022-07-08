package br.com.cleandomain.entities.ientities;

import br.com.cleandomain.entities.Cpf;
import br.com.cleandomain.entities.Email;
import br.com.cleandomain.entities.Functional;
import br.com.cleandomain.entities.Phone;

public interface IClient {
    String who();

    String getName();

    String getLastName();

    Email getEmail();

    Cpf getCpf();

    Phone getPhone();

    Functional getFunctional();

}
