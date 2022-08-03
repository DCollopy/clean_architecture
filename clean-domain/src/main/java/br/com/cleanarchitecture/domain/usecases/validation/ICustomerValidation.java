package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.Customer;

public interface ICustomerValidation {
    String validate(Customer customer);

    boolean customerTeamCompany(Customer customer);

    Customer createCustomer(Customer customer);
}
