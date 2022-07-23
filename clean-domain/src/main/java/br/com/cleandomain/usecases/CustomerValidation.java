package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.Customer;
import br.com.cleandomain.entities.repository.ICustomer;
import br.com.cleandomain.usecases.validation.ICustomerValidation;

import java.util.logging.Logger;

public class CustomerValidation implements ICustomerValidation {

    @Override
    public String validate(ICustomer client) {
        String message = "";
        if(client.getName() == null || client.getName().isEmpty()) {
            return "Name is required";
        }
        if(client.getLastName() == null || client.getLastName().isEmpty()) {
            return "Last name is required";
        }
        if(client.getEmail() == null || client.getEmail().getAddress().isEmpty()) {
            return "Email is required";
        }
        if(client.getCpf() == null || client.getCpf().getNumber().isEmpty()) {
            return "CPF is required";
        }
        if(client.getPhone() == null || client.getPhone().getNumber().isEmpty()) {
            return "Phone is required";
        }
        if(client.getFunctional() == null || client.getFunctional().getNumber().isEmpty()) {
            return "Functional is required";
        }
        if(client.getCompany() == null || client.getCompany().getCnpj().isEmpty()) {
            return "Company is required";
        }
        if(client.getCompany().getFantasyName() == null || client.getCompany().getFantasyName().isEmpty()) {
            return "Fantasy name is required";
        }
        return message;
    }

    public boolean customerTeamCompany(ICustomer customer) {
        if(customer.getCompany() == null) {
            return false;
        }
        return true;
    }

    public ICustomer createCustomer(ICustomer customer) {
        if(validate(customer).isEmpty()) {
            Logger.getLogger(CustomerValidation.class.getName()).info("Customer created");
            return new Customer(customer.getName(), customer.getLastName(), customer.getEmail(),
                    customer.getCpf(), customer.getPhone(), customer.getFunctional(), customer.getCompany());
        }
        Logger.getLogger(CustomerValidation.class.getName()).info("Customer does not create");
        throw new IllegalArgumentException("Customer does not create");
    }


}
