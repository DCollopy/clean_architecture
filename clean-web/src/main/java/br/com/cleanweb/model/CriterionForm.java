package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.ICriterion;
import lombok.Data;

@Data
public class CriterionForm {

    private Long id;
    private String title;
    private String description;
    private int pmd;
    private int weight;

    public CriterionForm(ICriterion criterion) {
        this.id = criterion.getId();
        this.title = criterion.getTitle();
        this.description = criterion.getDescription();
        this.pmd = criterion.getPmd();
        this.weight = criterion.getWeight();
    }
}
