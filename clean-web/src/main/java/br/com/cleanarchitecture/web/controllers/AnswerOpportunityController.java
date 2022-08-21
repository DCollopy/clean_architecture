package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.AnswerOpportunityService;
import br.com.cleanarchitecture.domain.entities.repository.JobOpportunityService;
import br.com.cleanarchitecture.web.model.AnswerOpportunityForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/venturarh/answer")
public class AnswerOpportunityController {

    private final AnswerOpportunityService answerOpportunityService;
    private final JobOpportunityService jobOpportunityService;

    public AnswerOpportunityController(AnswerOpportunityService answerOpportunityService, JobOpportunityService jobOpportunityService) {
        this.answerOpportunityService = answerOpportunityService;
        this.jobOpportunityService = jobOpportunityService;
    }

    @PostMapping("/create")
    public String createAnswerOpportunity(@Valid @RequestBody AnswerOpportunityForm answerOpportunityForm,
                                        @PathVariable(name= "who") String  who) {
        AnswerOpportunity answerConverter = answerOpportunityForm.answerOpportunityFormToAnswer();
        answerOpportunityService.save(answerConverter,who);
        jobOpportunityService.saveAnswer(answerConverter.getJobOpportunity().stream().iterator().next(), answerConverter);
        return "redirect:/answer";
    }
}
