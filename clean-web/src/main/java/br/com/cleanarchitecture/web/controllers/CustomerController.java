package br.com.cleanarchitecture.web.controllers;


import br.com.cleanarchitecture.domain.entities.Cnpj;
import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.CompanyService;
import br.com.cleanarchitecture.domain.entities.repository.CustomerService;
import br.com.cleanarchitecture.web.model.CustomerForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/venturarh/customer")
public class CustomerController {

    private final CustomerService customerService;

    private final CompanyService companyService;

    public CustomerController(CustomerService customerService, CompanyService companyService) {
        this.customerService = customerService;
        this.companyService = companyService;
    }

    @GetMapping({ "/{uid}" })
    public Customer index(@PathVariable String uid) {
        Customer customer = customerService.findByUid(uid);
        if(customer != null){
            return customer;
        } else {
            throw new IllegalArgumentException("UUID is null");
        }
    }

    @GetMapping({ "/{cpf}/job-opportunity" })
    public Set<JobOpportunity> listAllJobOpportunity(@PathVariable String cpf) {
        Cpf cpfView = new Cpf(cpf);
        return customerService.listAllJobOpportunity(customerService.findOne(cpfView));
    }

    @PostMapping(value = "/create",  consumes= MediaType.APPLICATION_JSON_VALUE)
    public String createCustomer(@Valid
                                     @RequestBody CustomerForm customerForm) {
        System.out.println(customerForm);
        System.out.println(customerForm.getCnpj());
        Customer customer = customerForm.convertCustomer();
        if(companyService.exist(new Cnpj(customerForm.getCnpj()))) {
            customer.setCompany(companyService.findOne(new Cnpj(customerForm.getCnpj())));
            customerService.save(customer);
            return "Customer created successfully";
        }
        return "Ops! Something went wrong";
    }

    //@GetMapping("/edit{cpf}")
    //public ResponseEntity<CustomerForm> editCustomer(@PathVariable String cpf) {
        //return ResponseEntity.ok(new CustomerForm(customerService.findOne(new Cpf(cpf))));
    //}

    @PutMapping("/edit{cpf}")
    public ResponseEntity<Customer> editCustomer(@Valid
                                                    @RequestBody CustomerForm customerForm,
                                                          String cpf) {
        Customer customer = customerForm.convertCustomer();
        return new ResponseEntity<>(customerService.edit(customer, new Cpf(cpf)), HttpStatus.OK);
    }


}
