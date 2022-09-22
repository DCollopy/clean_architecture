package br.com.cleanarchitecture.web.controllers;

import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.repository.CriterionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Convert;
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

    @GetMapping("details/{id}")
    public List<Criterion> detailsJob(@PathVariable String id){
        long convertId = Long.parseLong(id);
        return criterionService.findJob(convertId);
    }

}
