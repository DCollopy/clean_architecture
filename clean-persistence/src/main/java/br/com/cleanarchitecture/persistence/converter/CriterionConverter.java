package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.persistence.entities.CriterionEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class CriterionConverter {

    public Criterion convertToCriterion(CriterionEntity criterionEntity) {
        return new Criterion(
                criterionEntity.getTitle(),
                criterionEntity.getDescription(),
                criterionEntity.getPmd(),
                criterionEntity.getWeight()
        );
    }

    public CriterionEntity convertToCriterionEntity(Criterion criterion) {
        return new CriterionEntity(
                criterion.getTitle(),
                criterion.getDescription(),
                criterion.getPmd(),
                criterion.getWeight()
        );
    }

    public Set<Criterion> convertToCriterionSet(Set<CriterionEntity> criterionEntities) {
        return criterionEntities.stream().map(this::convertToCriterion).collect(Collectors.toSet());
    }

    public Set<CriterionEntity> convertToCriterionEntitySet(Set<Criterion> criteria) {
        return criteria.stream().map(this::convertToCriterionEntity).collect(Collectors.toSet());
    }
}
