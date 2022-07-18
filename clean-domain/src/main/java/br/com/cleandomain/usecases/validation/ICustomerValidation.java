package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Customer;
import br.com.cleandomain.entities.repository.ICustomer;

public interface ICustomerValidation {
    void createClient(ICustomer customer);

    boolean customerTeamCompany(ICustomer customer);

    Customer createCustomer(ICustomer customer);
}
