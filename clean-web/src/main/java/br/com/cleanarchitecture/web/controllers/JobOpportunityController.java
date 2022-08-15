package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.JobOpportunityService;
import br.com.cleanarchitecture.web.model.JobOpportunityForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/venturarh/job-opportunity")
public class JobOpportunityController {

    private final JobOpportunityService jobOpportunityService;

    public JobOpportunityController(JobOpportunityService jobOpportunityService) {
        this.jobOpportunityService = jobOpportunityService;
    }

    @GetMapping
    public List<JobOpportunity> index() {
        return jobOpportunityService.findAll();
    }

    @PostMapping("/create/{who}")
    public String createJobOpportunity(@Valid @RequestBody JobOpportunityForm jobOpportunityForm,
                                               @PathVariable(name= "who") String  who) {
        JobOpportunity jobOpportunity = jobOpportunityForm.convertToJobOpportunity();
        jobOpportunityService.save(jobOpportunity,who);
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

