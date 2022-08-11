package br.com.cleanarchitecture.persistence.service.criterion;


import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.repository.CriterionService;
import br.com.cleanarchitecture.persistence.converter.CriterionConverter;
import br.com.cleanarchitecture.persistence.entities.CriterionEntity;
import br.com.cleanarchitecture.persistence.repository.criterion.CriterionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriterionIml implements CriterionService {
    private final CriterionRepository criterionRepository;

    private final CriterionConverter criterionConverter = new CriterionConverter();

    private final CriterionAbs criterionValidation = new CriterionAbs();

    public CriterionIml(CriterionRepository criterionRepository) {
        this.criterionRepository = criterionRepository;
    }

    public void save(Criterion criterion) {
        Criterion validation = criterionValidation.createCriterion(criterion);
        if(validation != null){
            CriterionEntity criterionEntity = criterionConverter.convertToCriterionEntity(validation);
            criterionRepository.save(criterionEntity);
        }
    }


    public Criterion edit(Criterion criterion,long id) {
        Criterion validation = criterionValidation.editCriterion(criterion,id);
        if(validation != null){
            CriterionEntity criterionEntity = criterionConverter.convertToCriterionEntity(criterion);
            criterionRepository.save(criterionEntity);
        }
        return criterion;
    }

    public Criterion findOne(long id) {
        Optional<CriterionEntity> criterionEntity = criterionRepository.findById(id);
        return criterionConverter.convertToCriterion(criterionEntity.get());
    }


    public Boolean exist(long id) {
        return criterionRepository.existsById(id);
    }
}
