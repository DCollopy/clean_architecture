package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.Cnpj;

public interface ICompany {
    String getCnpj();

    String getFantasyName();

    void setCnpj(Cnpj cnpj);

    void setFantasyName(String fantasyName);
}
