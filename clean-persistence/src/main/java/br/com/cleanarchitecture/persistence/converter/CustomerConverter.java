package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.persistence.entities.CustomerEntity;

import java.util.Set;
import java.util.stream.Collectors;


public class CustomerConverter {

    public CustomerConverter(){}

    public Customer convertToCustomer(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getName(), customerEntity.getLastName(),
                new EmailConverter().convertToEmail(customerEntity.getEmail().getAddress()),
                new CpfConverter().convertToCpf(customerEntity.getCpf().getCpf()),
                new PhoneConverter().convertToPhone(customerEntity.getPhone().getDdd(), customerEntity.getPhone().getPhone()),
                new FunctionalConverter().convertToFunctional(customerEntity.getFunctional().getFunctional()),
                new CompanyConverter().convertCompanyEntitySetToCompany(customerEntity.getCompany()));
    }

    public CustomerEntity convertToCustomerEntity(Customer customer) {
        return new CustomerEntity(customer.getName(), customer.getLastName(),
                new EmailConverter().convertToEmailEntity(customer.getEmail().getAddress()),
                new CpfConverter().convertToCpfEntity(customer.getCpf().getNumber()),
                new PhoneConverter().convertToPhoneEntity(customer.getPhone().getDdd(), customer.getPhone().getNumber()),
                new FunctionalConverter().convertToFunctionalEntity(customer.getFunctional().getNumber()),
                new CompanyConverter().convertSaveToCompanySet(customer.getCompany()));
    }

    public Set<CustomerEntity> convertToCustomerSet(Set<Customer> customer) {
        return customer.stream().map(this::convertToCustomerEntity).collect(Collectors.toSet());
    }
}
