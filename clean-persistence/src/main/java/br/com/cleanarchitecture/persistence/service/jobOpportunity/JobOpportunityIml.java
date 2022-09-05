package br.com.cleanarchitecture.persistence.service.jobOpportunity;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.entities.repository.JobOpportunityService;
import br.com.cleanarchitecture.persistence.converter.JobOpportunityConverter;
import br.com.cleanarchitecture.persistence.entities.JobOpportunityEntity;
import br.com.cleanarchitecture.persistence.repository.jobOpportunity.JobOpportunityRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JobOpportunityIml implements JobOpportunityService {

    private final JobOpportunityRepository jobOpportunityRepository;

    private final JobOpportunityAbs jobOpportunityAbs = new JobOpportunityAbs();

    private final JobOpportunityConverter jobOpportunityConverter = new JobOpportunityConverter();

    public JobOpportunityIml(JobOpportunityRepository jobOpportunityRepository) {
        this.jobOpportunityRepository = jobOpportunityRepository;
    }


    public JobOpportunity findById(Long id) {
        Optional<JobOpportunityEntity> jobOpportunityEntity = jobOpportunityRepository.findById(id);
        return jobOpportunityConverter.jobOpportunityEntityId(jobOpportunityEntity.get());
    }

    public JobOpportunity save(JobOpportunity jobOpportunity, String whoYou) {
        JobOpportunity validation = jobOpportunityAbs.createJobOpportunity(jobOpportunity, whoYou);
        if(validation != null && !exists(jobOpportunity)){
            JobOpportunityEntity jobOpportunityEntity = jobOpportunityConverter.jobOpportunityToJobOpportunityEntity(jobOpportunity);
            JobOpportunityEntity jobEntity = jobOpportunityRepository.save(jobOpportunityEntity);
            return jobOpportunityConverter.jobOpportunityEntityId(jobEntity);
        }
        return jobOpportunity;
    }

    public void saveAnswer(JobOpportunity jobOpportunity, AnswerOpportunity answerOpportunity) {
        JobOpportunity job = findById(jobOpportunity.getId());
        if(job != null){
            job.setAnswerOpportunity(answerOpportunity);
            jobOpportunityRepository.save(jobOpportunityConverter.jobOpportunityToJobOpportunityEntity(job));
        }
    }

    public JobOpportunity edit(JobOpportunity jobOpportunity, long id) {
        JobOpportunity validation = jobOpportunityAbs.editJobOpportunity(jobOpportunity, id);
        if(validation != null && exists(jobOpportunity)){
            JobOpportunityEntity jobOpportunityEntity = jobOpportunityConverter.jobOpportunityToJobOpportunityEntity(jobOpportunity);
            jobOpportunityRepository.save(jobOpportunityEntity);
        }
        return validation;
    }

    public boolean isExpiredDay(JobOpportunity jobOpportunity) {
        return false;
    }

    public List<JobOpportunity> findAll() {
        return jobOpportunityConverter.jobOpportunityEntityListToJobOpportunityList(jobOpportunityRepository.findAll());
    }

    public JobOpportunity findJob(long id) {
        return jobOpportunityConverter.jobOpportunityEntityToJobOpportunity(jobOpportunityRepository.findById(id).get());
    }

    public boolean exists(JobOpportunity jobOpportunity) {
        return jobOpportunityRepository.existsById(jobOpportunity.getId());
    }

    public JobOpportunity findCustomerOpportunity(JobOpportunity jobOpportunity) {
        JobOpportunity findJob = findById(jobOpportunity.getId());
        Cpf cpf = findJob.getCustomer().getCpf();
        return jobOpportunityAbs.customerJobOpportunity(findJob,cpf);
    }

    public void delete(JobOpportunity jobOpportunity, Cpf cpf) {
        JobOpportunity validation = jobOpportunityAbs.deleteJobOpportunity(jobOpportunity, cpf);
        if(validation != null){
            jobOpportunityRepository.deleteById(jobOpportunity.getId());
        }
    }
}
