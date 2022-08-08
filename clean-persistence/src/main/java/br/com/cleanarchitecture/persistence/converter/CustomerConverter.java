package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.persistence.entities.CompanyEntity;
import br.com.cleanarchitecture.persistence.entities.CustomerEntity;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerConverter {

    public CustomerConverter(){}

    public Customer convertToCustomerCompany(CustomerEntity customerEntity) {
        CompanyEntity companyEntity = new CompanyConverter().convertCompanyEntitySetToCompany(customerEntity.getCompany());

        return new Customer(customerEntity.getName(), customerEntity.getLastName(),
                new EmailConverter().convertToEmail(customerEntity.getEmail().getAddress()),
                new CpfConverter().convertToCpf(customerEntity.getCpf().getCpf()),
                new PhoneConverter().convertToPhone(customerEntity.getPhone().getDdd(), customerEntity.getPhone().getPhone()),
                new FunctionalConverter().convertToFunctional(customerEntity.getFunctional().getFunctional()),
                new CompanyConverter().convertToCompany(companyEntity));
    }

    public CustomerEntity convertToCustomerEntityCompany(Customer customer) {
        return new CustomerEntity(customer.getName(), customer.getLastName(),
                new EmailConverter().convertToEmailEntity(customer.getEmail().getAddress()),
                new CpfConverter().convertToCpfEntity(customer.getCpf().getNumber()),
                new PhoneConverter().convertToPhoneEntity(customer.getPhone().getDdd(), customer.getPhone().getNumber()),
                new FunctionalConverter().convertToFunctionalEntity(customer.getFunctional().getNumber()),
                new CompanyConverter().convertSaveToCompanySet(customer.getCompany()));
    }

    public Customer convertToCustomer(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getName(), customerEntity.getLastName(),
                new EmailConverter().convertToEmail(customerEntity.getEmail().getAddress()),
                new CpfConverter().convertToCpf(customerEntity.getCpf().getCpf()),
                new PhoneConverter().convertToPhone(customerEntity.getPhone().getDdd(), customerEntity.getPhone().getPhone()),
                new FunctionalConverter().convertToFunctional(customerEntity.getFunctional().getFunctional()));
    }

    public CustomerEntity convertToCustomerEntity(Customer customer) {
        return new CustomerEntity(customer.getName(), customer.getLastName(),
                new EmailConverter().convertToEmailEntity(customer.getEmail().getAddress()),
                new CpfConverter().convertToCpfEntity(customer.getCpf().getNumber()),
                new PhoneConverter().convertToPhoneEntity(customer.getPhone().getDdd(), customer.getPhone().getNumber()),
                new FunctionalConverter().convertToFunctionalEntity(customer.getFunctional().getNumber()));
    }

    public Set<Customer> convertCustomerEntitySetToCustomerSet(Set<CustomerEntity> customerEntitySet) {
        Set<Customer> customerSet = new java.util.HashSet<>();
        for (CustomerEntity customerEntity : customerEntitySet) {
            customerSet.add(convertToCustomerCompany(customerEntity));
        }
        return customerSet;
    }

    public Set<CustomerEntity> convertCustomerSetToCustomerEntitySet(Set<Customer> customerSet) {
        Set<CustomerEntity> customerEntitySet = new java.util.HashSet<>();
        for (Customer customer : customerSet) {
            customerEntitySet.add(convertToCustomerEntityCompany(customer));
        }
        return customerEntitySet;
    }

    public Set<CustomerEntity> convertCustomerEntityToCustomerEntitySet(CustomerEntity customerEntity) {
        return Stream.of(customerEntity).collect(Collectors.toSet());
    }
}
