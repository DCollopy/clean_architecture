package br.com.cleanarchitecture.persistence.service.jobOpportunity;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.repository.JobOpportunityService;
import br.com.cleanarchitecture.persistence.converter.JobOpportunityConverter;
import br.com.cleanarchitecture.persistence.entities.JobOpportunityEntity;
import br.com.cleanarchitecture.persistence.repository.jobOpportunity.JobOpportunityRepository;

import java.util.List;
import java.util.Optional;

public class JobOpportunityIml implements JobOpportunityService {

    private final JobOpportunityRepository jobOpportunityRepository;

    private final JobOpportunityAbs jobOpportunityAbs = new JobOpportunityAbs();

    private final JobOpportunityConverter jobOpportunityConverter = new JobOpportunityConverter();

    public JobOpportunityIml(JobOpportunityRepository jobOpportunityRepository) {
        this.jobOpportunityRepository = jobOpportunityRepository;
    }


    public JobOpportunity findById(Long id) {
        Optional<JobOpportunityEntity> jobOpportunityEntity = jobOpportunityRepository.findById(id);
        return jobOpportunityConverter.jobOpportunityEntityToJobOpportunity(jobOpportunityEntity.get());
    }

    public void save(JobOpportunity jobOpportunity, String whoYou) {
        JobOpportunity validation = jobOpportunityAbs.createJobOpportunity(jobOpportunity, whoYou);
        if(validation != null){
            JobOpportunityEntity jobOpportunityEntity = jobOpportunityConverter.jobOpportunityToJobOpportunityEntity(jobOpportunity);
            jobOpportunityRepository.save(jobOpportunityEntity);
        }

    }

    public JobOpportunity edit(JobOpportunity jobOpportunity, long id) {
        JobOpportunity validation = jobOpportunityAbs.editJobOpportunity(jobOpportunity, id);
        if(validation != null){
            JobOpportunityEntity jobOpportunityEntity = jobOpportunityConverter.jobOpportunityToJobOpportunityEntity(jobOpportunity);
            jobOpportunityRepository.save(jobOpportunityEntity);
        }
        return validation;
    }

    public boolean isExpiredDay(JobOpportunity jobOpportunity) {
        return false;
    }

    public List<JobOpportunity> findAllCustomerOpportunity(Cpf cpf) {
        return null;
    }

    public void delete(JobOpportunity jobOpportunity, Cpf cpf) {

    }
}
