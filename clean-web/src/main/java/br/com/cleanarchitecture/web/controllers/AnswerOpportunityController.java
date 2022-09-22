package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.entities.repository.AnswerOpportunityService;
import br.com.cleanarchitecture.domain.entities.repository.CriterionService;
import br.com.cleanarchitecture.domain.entities.repository.JobOpportunityService;
import br.com.cleanarchitecture.domain.entities.repository.UserService;
import br.com.cleanarchitecture.web.model.AnswerOpportunityForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/venturarh/answer")
public class AnswerOpportunityController {

    private final AnswerOpportunityService answerOpportunityService;
    private final JobOpportunityService jobOpportunityService;
    private final UserService userService;
    private final CriterionService criterionService;

    public AnswerOpportunityController(AnswerOpportunityService answerOpportunityService, JobOpportunityService jobOpportunityService, UserService userService, CriterionService criterionService) {
        this.answerOpportunityService = answerOpportunityService;
        this.jobOpportunityService = jobOpportunityService;
        this.userService = userService;
        this.criterionService = criterionService;
    }

    @PostMapping("/create/{uid}")
    public String createAnswerOpportunity(@Valid @RequestBody AnswerOpportunityForm answerOpportunityForm,
                                            @PathVariable(name= "uid") String  uid) {
        User user = userService.findOneUid(uid);
        List<Criterion> jobInCriterion = criterionService.findJob(answerOpportunityForm.getJobOpportunity());
        AnswerOpportunity answerConverter = answerOpportunityForm.answerOpportunityFormToAnswer(jobInCriterion, user);

        answerOpportunityService.save(answerConverter,user.who());
        jobOpportunityService.saveAnswer(answerConverter.getCriterion().stream().findFirst().get().getJobOpportunity(), answerConverter);
        return "redirect:/answer";
    }
}
