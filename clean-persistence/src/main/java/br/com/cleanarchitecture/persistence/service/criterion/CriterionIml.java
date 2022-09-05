package br.com.cleanarchitecture.persistence.service.criterion;


import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.CriterionService;
import br.com.cleanarchitecture.persistence.converter.CriterionConverter;
import br.com.cleanarchitecture.persistence.entities.CriterionEntity;
import br.com.cleanarchitecture.persistence.entities.JobOpportunityEntity;
import br.com.cleanarchitecture.persistence.repository.criterion.CriterionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CriterionIml implements CriterionService {
    private final CriterionRepository criterionRepository;

    private final CriterionConverter criterionConverter = new CriterionConverter();

    private final CriterionAbs criterionValidation = new CriterionAbs();

    public CriterionIml(CriterionRepository criterionRepository) {
        this.criterionRepository = criterionRepository;
    }

    public void save(Set<Criterion> criterion, JobOpportunity jobOpportunity) {
        for (Criterion criterionSet : criterion) {
            Criterion validation = criterionValidation.createCriterion(criterionSet);
            if(validation != null){
                validation.setJobOpportunity(jobOpportunity);
                CriterionEntity criterionEntity = criterionConverter.convertToCriterionEntityJob(validation);
                criterionRepository.saveAndFlush(criterionEntity);
            }
        }
    }


    public Criterion edit(Criterion criterion,long id) {
        Criterion validation = criterionValidation.editCriterion(criterion,id);
        if(validation != null){
            CriterionEntity criterionEntity = criterionConverter.convertToCriterionEntityJob(criterion);
            criterionRepository.save(criterionEntity);
        }
        return criterion;
    }

    public Criterion findOne(long id) {
        Optional<CriterionEntity> criterionEntity = criterionRepository.findById(id);
        return criterionConverter.convertToCriterionJob(criterionEntity.get());
    }

    public List<Criterion> findAll (){
        return criterionConverter.convertToCriterionList(criterionRepository.findAll());
    }

    public List<Criterion> findJob(long id) {
        JobOpportunityEntity jobId = new JobOpportunityEntity(id);
        List<CriterionEntity> job = criterionRepository.findByJobOpportunity(jobId);
        return criterionConverter.convertToCriterionList(job.stream().toList());
    }


    public Boolean exist(long id) {
        return criterionRepository.existsById(id);
    }
}
