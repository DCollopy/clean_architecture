package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.persistence.entities.CustomerEntity;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CustomerConverter {

    public CustomerConverter(){}

    public Customer convertToCustomer(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getUuid(),customerEntity.getName(), customerEntity.getLastName(),
                new EmailConverter().convertToEmail(customerEntity.getEmail().getAddress()),
                new CpfConverter().convertToCpf(customerEntity.getCpf().getCpf()),
                new PhoneConverter().convertToPhone(customerEntity.getPhone().getDdd(), customerEntity.getPhone().getPhone()),
                new FunctionalConverter().convertToFunctional(customerEntity.getFunctional().getFunctional()),
                new CompanyConverter().convertToCompany(customerEntity.getCompany()));
    }

    public CustomerEntity convertToCustomerEntity(Customer customer) {
        return new CustomerEntity(customer.getUuid(),customer.getName(), customer.getLastName(),
                new EmailConverter().convertToEmailEntity(customer.getEmail().getAddress()),
                new CpfConverter().convertToCpfEntity(customer.getCpf().getNumber()),
                new PhoneConverter().convertToPhoneEntity(customer.getPhone().getDdd(), customer.getPhone().getNumber()),
                new FunctionalConverter().convertToFunctionalEntity(customer.getFunctional().getNumber()),
                new CompanyConverter().convertToCompanyEntity(customer.getCompany()));
    }

    public Set<CustomerEntity> convertToCustomerSetEntity(Set<Customer> customer) {
        return customer.stream().map(this::convertToCustomerEntity).collect(Collectors.toSet());
    }

    public Set<Customer> convertToCustomerSet(Customer customer) {
        return Stream.of(customer).collect(Collectors.toSet());
    }

}
