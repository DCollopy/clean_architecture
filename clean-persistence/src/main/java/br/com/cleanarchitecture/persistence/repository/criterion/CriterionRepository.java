package br.com.cleanarchitecture.persistence.repository.criterion;

import br.com.cleanarchitecture.persistence.entities.CriterionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterionRepository extends JpaRepository<CriterionEntity, Long> {
}
