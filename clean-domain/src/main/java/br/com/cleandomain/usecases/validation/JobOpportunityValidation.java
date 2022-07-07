package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.JobOpportunity;

public class JobOpportunityValidation implements IJobOpportunityValidation {


    @Override
    public void validate(JobOpportunity jobOpportunity) {
//        if(!opportunityExists(jobOpportunity.getId())){
//            throw new IllegalArgumentException("Opportunity not exists");
//        }
//        if(isExpired(jobOpportunity.isStatus(), jobOpportunity.getClosingDate())){
//            throw new IllegalArgumentException("Opportunity is expired");
//        }
    }

    @Override
    public boolean opportunityExists(String id) {
        return false;
    }

    @Override
    public boolean isExpired(boolean status, String closingDate) {
        return false;
    }
}
