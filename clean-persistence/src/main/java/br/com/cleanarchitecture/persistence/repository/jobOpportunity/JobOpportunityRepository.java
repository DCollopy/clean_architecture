package br.com.cleanarchitecture.persistence.repository.jobOpportunity;

import br.com.cleanarchitecture.persistence.entities.JobOpportunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOpportunityRepository extends JpaRepository<JobOpportunityEntity, Long> {

}
