package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;

import java.util.Set;

public interface CustomerService {

    public void save(Customer customer);

    public Customer edit(Customer customer, Cpf cpf);

    public Boolean exist(Cpf cpf);

    public Customer findOne(Cpf cpf);

    Set<JobOpportunity> listAllJobOpportunity(Customer customer);
}
