package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Customer;

public interface ICustomerValidation {
    String validate(Customer customer);

    boolean customerTeamCompany(Customer customer);

    Customer createCustomer(Customer customer);
}
