package br.com.cleanarchitecture.persistence.repository.criterion;

import br.com.cleanarchitecture.persistence.entities.CriterionEntity;
import br.com.cleanarchitecture.persistence.entities.JobOpportunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CriterionRepository extends JpaRepository<CriterionEntity, Long> {

    List<CriterionEntity> findByJobOpportunity(JobOpportunityEntity id);
}
