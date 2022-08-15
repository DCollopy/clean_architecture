package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.persistence.entities.JobOpportunityEntity;

import java.util.List;
import java.util.stream.Collectors;

public class JobOpportunityConverter {

    public JobOpportunity jobOpportunityEntityToJobOpportunity(JobOpportunityEntity jobOpportunityEntity) {
        return new JobOpportunity(jobOpportunityEntity.getTitle(),
                jobOpportunityEntity.getDescription(),
                jobOpportunityEntity.getLanguage(),
                jobOpportunityEntity.getClosingDate(),
                jobOpportunityEntity.getEducationLevel(),
                jobOpportunityEntity.getSalary(),
                new CriterionConverter().convertToCriterionSet(jobOpportunityEntity.getCriterion()),
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
                new CriterionConverter().convertToCriterionEntitySet(jobOpportunity.getCriterion()),
                new CustomerConverter().convertToCustomerEntity(jobOpportunity.getCustomer()),
                jobOpportunity.getMinimumProfile());
    }

    public List<JobOpportunity> jobOpportunityEntityListToJobOpportunityList(List<JobOpportunityEntity> jobOpportunityEntityList) {
        return jobOpportunityEntityList.stream().map(this::jobOpportunityEntityToJobOpportunity).collect(Collectors.toList());
    }
}
