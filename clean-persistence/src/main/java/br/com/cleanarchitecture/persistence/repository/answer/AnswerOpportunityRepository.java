package br.com.cleanarchitecture.persistence.repository.answer;

import br.com.cleanarchitecture.persistence.entities.AnswerOpportunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AnswerOpportunityRepository extends JpaRepository<AnswerOpportunityEntity,Long> {

}