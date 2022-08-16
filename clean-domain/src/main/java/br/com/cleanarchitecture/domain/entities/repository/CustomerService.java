package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;

import java.util.Set;

public interface CustomerService {

    void save(Customer customer);

    Customer edit(Customer customer, Cpf cpf);

    Boolean exist(Cpf cpf);

    Customer findOne(Cpf cpf);

    void saveJobOpportunity(Customer customer,JobOpportunity jobOpportunity);

    Set<JobOpportunity> listAllJobOpportunity(Customer customer);
}
