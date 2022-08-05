package br.com.cleanarchitecture.web.controllers;


import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.repository.CustomerService;
import br.com.cleanarchitecture.web.model.CompanyForm;
import br.com.cleanarchitecture.web.model.CustomerForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/venturarh/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({ "/{cpf}" })
    public String index(@PathVariable String cpf) {
        Cpf cpfView = new Cpf(cpf);
        return customerService.findOne(cpfView).toString();
    }

    @PostMapping("/create")
    public String createCustomer(@Valid
                                     @RequestBody CustomerForm customerForm) {
        Customer customer = customerForm.convertCustomer();
        customerService.save(customer);
        return "Create customer";
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
