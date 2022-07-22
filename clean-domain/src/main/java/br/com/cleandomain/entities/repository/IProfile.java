package br.com.cleandomain.entities.repository;

public interface IProfile {
    String who();

    String getName();

    String getLastName();

    br.com.cleandomain.entities.Email getEmail();

    br.com.cleandomain.entities.Cpf getCpf();

    br.com.cleandomain.entities.Phone getPhone();

    void setName(String name);

    void setLastName(String lastName);

    void setEmail(br.com.cleandomain.entities.Email email);

    void setCpf(br.com.cleandomain.entities.Cpf cpf);

    void setPhone(br.com.cleandomain.entities.Phone phone);
}
