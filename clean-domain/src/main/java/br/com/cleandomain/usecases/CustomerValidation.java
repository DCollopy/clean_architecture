package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.Customer;
import br.com.cleandomain.entities.repository.ICustomer;
import br.com.cleandomain.usecases.validation.ICustomerValidation;

import java.util.logging.Logger;

public class CustomerValidation implements ICustomerValidation {

    @Override
    public void createClient(ICustomer client) {
        if(client.getName() == null || client.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if(client.getLastName() == null || client.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is required");
        }
        if(client.getEmail() == null || client.getEmail().getAddress().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if(client.getCpf() == null || client.getCpf().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Cpf is required");
        }
        if(client.getPhone() == null || client.getPhone().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone is required");
        }
        if(client.getFunctional() == null || client.getFunctional().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Functional is required");
        }
        if(client.getCompany() == null || client.getCompany().getCnpj().isEmpty()) {
            throw new IllegalArgumentException("Cnpj is required");
        }
        if(client.getCompany().getFantasyName() == null || client.getCompany().getFantasyName().isEmpty()) {
            throw new IllegalArgumentException("FantasyName is required");
        }
    }

    public boolean customerTeamCompany(ICustomer customer) {
        if(customer.getCompany() == null) {
            return false;
        }
        return true;
    }

    public Customer createCustomer(ICustomer customer) {
        if(customerTeamCompany(customer)){
            Logger.getLogger(CustomerValidation.class.getName()).info("Customer created");
            return new Customer(customer.getName(), customer.getLastName(), customer.getEmail(),
                    customer.getCpf(), customer.getPhone(), customer.getFunctional(), customer.getCompany());
        }
        Logger.getLogger(CustomerValidation.class.getName()).info("Customer does not have company");
       return null;
    }


}
