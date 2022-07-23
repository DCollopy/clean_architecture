package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Customer;
import br.com.cleandomain.entities.repository.ICustomer;

public interface ICustomerValidation {
    String validate(ICustomer customer);

    boolean customerTeamCompany(ICustomer customer);

    ICustomer createCustomer(ICustomer customer);
}
