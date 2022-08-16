package br.com.cleanarchitecture.web.controllers;


import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.CompanyService;
import br.com.cleanarchitecture.domain.entities.repository.CustomerService;
import br.com.cleanarchitecture.web.model.CustomerForm;
import org.springframework.http.HttpStatus;
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

    @GetMapping({ "/{cpf}" })
    public String index(@PathVariable String cpf) {
        Cpf cpfView = new Cpf(cpf);
        return customerService.findOne(cpfView).toString();
    }

    @GetMapping({ "/{cpf}/job-opportunity" })
    public Set<JobOpportunity> listAllJobOpportunity(@PathVariable String cpf) {
        Cpf cpfView = new Cpf(cpf);
        return customerService.listAllJobOpportunity(customerService.findOne(cpfView));
    }

    @PostMapping("/create")
    public String createCustomer(@Valid
                                     @RequestBody CustomerForm customerForm) {
        Customer customer = customerForm.convertCustomer();
        if(companyService.exist(customer.getCompanyCnpjObj())){
            customerService.save(customer);
            companyService.saveCustomer(customer.getCompany());
            return "Customer created successfully";
        }
        return "Ops! Something went wrong";
    }

    @GetMapping("/edit{cpf}")
    public ResponseEntity<CustomerForm> editCustomer(@PathVariable String cpf) {
        return ResponseEntity.ok(new CustomerForm(customerService.findOne(new Cpf(cpf))));
    }

    @PutMapping("/edit{cpf}")
    public ResponseEntity<Customer> editCustomer(@Valid
                                                    @RequestBody CustomerForm customerForm,
                                                          String cpf) {
        Customer customer = customerForm.convertCustomer();
        return new ResponseEntity<>(customerService.edit(customer, new Cpf(cpf)), HttpStatus.OK);
    }


}
