package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.Customer;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.CriterionService;
import br.com.cleanarchitecture.domain.entities.repository.CustomerService;
import br.com.cleanarchitecture.domain.entities.repository.JobOpportunityService;
import br.com.cleanarchitecture.web.model.CriterionForm;
import br.com.cleanarchitecture.web.model.CustomerForm;
import br.com.cleanarchitecture.web.model.JobOpportunityForm;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/venturarh/job-opportunity")
public class JobOpportunityController {

    private final JobOpportunityService jobOpportunityService;
    private final CustomerService customerService;

    private final CriterionService criterionService;

    public JobOpportunityController(JobOpportunityService jobOpportunityService, CustomerService customerService, CriterionService criterionService) {
        this.jobOpportunityService = jobOpportunityService;
        this.customerService = customerService;
        this.criterionService = criterionService;
    }

    @GetMapping
    public List<JobOpportunity> index() {
        return jobOpportunityService.findAll();
    }

    @PostMapping(value="/create/{uuid}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public String createJobOpportunity(@Valid @RequestBody JobOpportunityForm jobOpportunityForm,
                                               @PathVariable(name= "uuid") String  uuid) {
        JobOpportunity jobOpportunity = jobOpportunityForm.convertToJobOpportunity();
        Set<Criterion> criterion = new CriterionForm().convertToCriterionSet(jobOpportunityForm.getCriterion());
        Customer customer = customerService.findByUid(uuid);

        jobOpportunity.setCustomer(customer);
        jobOpportunity.setCriterion(criterion);

        JobOpportunity job = jobOpportunityService.save(jobOpportunity,customer.who());

        criterionService.save(criterion,job);
        return "redirect:/job-opportunity";
    }

    @GetMapping("/{id}")
    public JobOpportunity findById(@PathVariable Long id) {
        return jobOpportunityService.findById(id);
    }

    @GetMapping("/customer-opportunity/{id}")
    public JobOpportunity findCustomerOpportunity(@PathVariable Long id) {
        return jobOpportunityService.findCustomerOpportunity(jobOpportunityService.findJob(id));
    }


    @PutMapping("/{id}")
    public JobOpportunity edit(@Valid @RequestBody JobOpportunityForm jobOpportunityForm,
                                @PathVariable Long id) {
        return jobOpportunityService.edit(jobOpportunityForm.convertToJobOpportunity(),id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        JobOpportunity job = jobOpportunityService.findById(id);
        jobOpportunityService.delete(job,job.getCustomer().getCpf());
    }
}

