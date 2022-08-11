package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Criterion;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class CriterionForm {

    private String title;
    private String description;
    private int pmd;
    private int weight;

    public CriterionForm(Criterion criterion) {
        this.title = criterion.getTitle();
        this.description = criterion.getDescription();
        this.pmd = criterion.getPmd();
        this.weight = criterion.getWeight();
    }

    public Criterion convertToCriterion() {
        return new Criterion(this.getTitle(), this.getDescription(), this.getPmd(), this.getWeight());
    }

    public Set<Criterion> convertToCriterionSet() {
        return Stream.of(this).map(CriterionForm::convertToCriterion).collect(Collectors.toSet());
    }
}
