package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;

public interface CompanyService {

    void save(Company company);

    Company findOne(Cnpj cnpj);

    Boolean exist(Cnpj cnpj);

}
