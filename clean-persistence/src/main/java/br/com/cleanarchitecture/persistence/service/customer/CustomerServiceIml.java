package br.com.cleanarchitecture.persistence.service.customer;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.CustomerService;
import br.com.cleanarchitecture.persistence.converter.CpfConverter;
import br.com.cleanarchitecture.persistence.converter.CustomerConverter;
import br.com.cleanarchitecture.persistence.entities.CpfEntity;
import br.com.cleanarchitecture.persistence.entities.CustomerEntity;
import br.com.cleanarchitecture.persistence.repository.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceIml implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter = new CustomerConverter();

    private final CpfConverter cpfConverter = new CpfConverter();

    private final CustomerValidationAbs customerValidation = new CustomerValidationAbs();

    public CustomerServiceIml(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        Customer validation = customerValidation.createCustomer(customer);
        if(validation != null){
            CustomerEntity customerEntity = customerConverter.convertToCustomerEntity(validation);
            customerRepository.save(customerEntity);
        }
    }

    public void saveJobOpportunity(Customer customer, JobOpportunity jobOpportunity) {
        Customer addJobOpportunity = customerValidation.addCustomerJobOpportunity(customer, jobOpportunity);
        customerRepository.save(customerConverter.convertToCustomerEntity(addJobOpportunity));
    }

    public Customer edit(Customer customer, Cpf cpf) {
        Customer validation = customerValidation.editCustomer(customer,cpf);
        if(validation != null){
            CustomerEntity customerEntity = customerConverter.convertToCustomerEntity(customer);
            customerRepository.save(customerEntity);
        }
        return customer;
    }


    public Boolean exist(Cpf cpf) {
        CpfEntity cpfEntity = cpfConverter.convertToCpfEntity(cpf.getNumber());
        return customerRepository.existsById(cpfEntity);
    }


    public Customer findOne(Cpf cpf) {
        Optional<CustomerEntity> customerEntity = customerRepository.
                findById(cpfConverter.convertToCpfEntity(cpf.getNumber()));
        return customerConverter.convertToCustomer(customerEntity.get());
    }

    public Set<JobOpportunity> listAllJobOpportunity(Customer customer) {
        return customerValidation.listAllJobOpportunities(customer);
    }
}
