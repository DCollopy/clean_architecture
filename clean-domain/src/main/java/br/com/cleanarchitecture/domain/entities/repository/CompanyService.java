package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Company;
import br.com.cleanarchitecture.domain.entities.Customer;


import java.util.List;


public interface CompanyService {

    void save(Company company,String whoYou);

    Company findOne(Cnpj cnpj);

    Boolean exist(Cnpj cnpj);

    List<Company> listAll();

    Company edit(Company company, Cnpj cnpj,String whoYou);

    void saveCustomer(String cnpj, Customer customer);

}
