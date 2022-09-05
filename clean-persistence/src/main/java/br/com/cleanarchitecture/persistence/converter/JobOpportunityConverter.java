package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.persistence.entities.JobOpportunityEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JobOpportunityConverter {

    public JobOpportunity jobOpportunityEntityToJobOpportunity(JobOpportunityEntity jobOpportunityEntity) {
        return new JobOpportunity(jobOpportunityEntity.getTitle(),
                jobOpportunityEntity.getDescription(),
                jobOpportunityEntity.getLanguage(),
                jobOpportunityEntity.getClosingDate(),
                jobOpportunityEntity.getEducationLevel(),
                jobOpportunityEntity.getSalary(),
                new CustomerConverter().convertToCustomer(jobOpportunityEntity.getCustomer()),
                jobOpportunityEntity.getMinimumProfile());
    }

    public JobOpportunityEntity jobOpportunityToJobOpportunityEntity(JobOpportunity jobOpportunity) {
        return new JobOpportunityEntity(jobOpportunity.getTitle(),
                jobOpportunity.getDescription(),
                jobOpportunity.getLanguage(),
                jobOpportunity.getClosingDate(),
                jobOpportunity.getEducationLevel(),
                jobOpportunity.getSalary(),
                new CustomerConverter().convertToCustomerEntity(jobOpportunity.getCustomer()),
                jobOpportunity.getMinimumProfile());
    }

    public JobOpportunity jobOpportunityEntityId(JobOpportunityEntity jobOpportunityEntity) {
        return new JobOpportunity(jobOpportunityEntity.getId(),jobOpportunityEntity.getTitle(),
                jobOpportunityEntity.getDescription(),
                jobOpportunityEntity.getLanguage(),
                jobOpportunityEntity.getClosingDate(),
                jobOpportunityEntity.getEducationLevel(),
                jobOpportunityEntity.getSalary(),
                new CustomerConverter().convertToCustomer(jobOpportunityEntity.getCustomer()),
                jobOpportunityEntity.getMinimumProfile());
    }

    public JobOpportunity convertJobOpportunityCriterion(JobOpportunityEntity jobOpportunityEntity) {
        return new JobOpportunity(jobOpportunityEntity.getId());
    }

    public JobOpportunityEntity convertJobOpportunityEntityCriterion(JobOpportunity jobOpportunity) {
        return new JobOpportunityEntity(jobOpportunity.getId());
    }

    public List<JobOpportunity> jobOpportunityEntityListToJobOpportunityList(List<JobOpportunityEntity> jobOpportunityEntityList) {
        return jobOpportunityEntityList.stream().map(this::jobOpportunityEntityToJobOpportunity).collect(Collectors.toList());
    }

    public Set<JobOpportunity> jobOpportunityEntitySetToJobOpportunitySet(Set<JobOpportunityEntity> jobOpportunityEntity) {
        return jobOpportunityEntity.stream().map(this::jobOpportunityEntityToJobOpportunity).collect(Collectors.toSet());
    }

    public Set<JobOpportunityEntity> jobOpportunitySetToJobOpportunityEntitySet(Set<JobOpportunity> jobOpportunity) {
        return jobOpportunity.stream().map(this::jobOpportunityToJobOpportunityEntity).collect(Collectors.toSet());
    }


}
