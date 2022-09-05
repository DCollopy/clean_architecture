package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.repository.CriterionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/venturarh/criterion")
public class CriterionController {

    private final CriterionService criterionService;

    public CriterionController(CriterionService criterionService) {
        this.criterionService = criterionService;
    }

    @GetMapping
    public List<Criterion> index(){
        return criterionService.findAll();
    }

    @GetMapping("{id}/details")
    public List<Criterion> detailsJob(@PathVariable Long id){
        return criterionService.findJob(id);
    }

}
