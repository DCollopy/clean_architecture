package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Criterion;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class CriterionForm {

    private String title;
    private String description;
    private int pmd;
    private int weight;

    public CriterionForm(){}

    public static Criterion convertToCriterion(CriterionForm criterionForm) {
        return new Criterion(criterionForm.getTitle(), criterionForm.getDescription(), criterionForm.getPmd(), criterionForm.getWeight());
    }

    public Set<Criterion> convertToCriterionSet(Set<CriterionForm> criterion) {
        return criterion.stream().map(CriterionForm::convertToCriterion).collect(Collectors.toSet());
    }
    public Set<Criterion> convertToCriterionList(List<Criterion> criterion) {
        return new HashSet<>(criterion);
    }


}
