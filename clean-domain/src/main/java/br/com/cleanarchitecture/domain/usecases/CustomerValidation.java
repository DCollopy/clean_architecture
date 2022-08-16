package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.*;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class CustomerValidation {


    public String validate(Customer client) {
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

    public boolean customerTeamCompany(Customer customer) {
        if(customer.getCompany() == null) {
            return false;
        }
        return true;
    }

    public Customer createCustomer(Customer customer) {
        if(validate(customer).isEmpty()) {
            Logger.getLogger(CustomerValidation.class.getName()).info("Customer created");
            return new Customer(customer.getName(), customer.getLastName(), customer.getEmail(),
                    customer.getCpf(), customer.getPhone(), customer.getFunctional(), customer.getCompany());
        }
        Logger.getLogger(CustomerValidation.class.getName()).info("Customer does not create");
        throw new IllegalArgumentException("Customer does not create");
    }

    public Customer editCustomer(Customer customer, Cpf cpf) {
        if (validate(customer).isEmpty() && cpf.getNumber().equals(customer.getCpf().getNumber())) {
            Logger.getLogger(CustomerValidation.class.getName()).info("Customer edited");
            return new Customer(customer.getName(), customer.getLastName(), customer.getEmail(),
                    customer.getCpf(), customer.getPhone(), customer.getFunctional());
        } else {
            throw new IllegalArgumentException("Customer does not edit");
        }
    }

    public Customer addCustomerCompany(Customer customer) {
        if(customer.getCompany() == null) {
            Company company = new Company(
                    new Cnpj(customer.getCompanyCnpj()), customer.getCompany().getFantasyName());
            customer.setCompany(company);
            return customer;
        } else {
            throw new IllegalArgumentException("Company already added");
        }
    }

    public Customer addCustomerJobOpportunity(Customer customer, JobOpportunity jobOpportunity) {
        customer.setJobOpportunities(Stream.of(jobOpportunity).collect(Collectors.toSet()));
        return customer;
    }
    public Set<JobOpportunity> listAllJobOpportunities(Customer customers) {
        return customers.getJobOpportunities();
    }

    public boolean custumerIsCustumer(Customer customer) {
        return customer.getType().equals("CUSTOMER");
    }

    public String whoYou(){
        return "Customer";
    }

}
