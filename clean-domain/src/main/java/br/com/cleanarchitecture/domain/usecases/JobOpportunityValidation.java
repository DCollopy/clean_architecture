package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public abstract class JobOpportunityValidation {

    public String validate(JobOpportunity jobOpportunity) {
        String message = "";
        if (jobOpportunity.getTitle() == null || jobOpportunity.getTitle().isEmpty()) {
            return "Title is required";
        }
        if (jobOpportunity.getDescription() == null || jobOpportunity.getDescription().isEmpty()) {
            return "Description is required";
        }
        if (jobOpportunity.getCriterion() == null) {
            return "Criterion is required";
        }
        if( jobOpportunity.getCustomer().getCpf() == null || jobOpportunity.getCustomer().getCpf().getNumber().isEmpty()){
            return "CPF is required";
        }
        return message;
    }

    public JobOpportunity createJobOpportunity(JobOpportunity jobOpportunity, String whoYou) {
        closingDay(jobOpportunity);

        if (validate(jobOpportunity).isEmpty() && whoYou.equals("CUSTOMER")) {
            Logger.getLogger(JobOpportunityValidation.class.getName()).info("JobOpportunity created");
           return new JobOpportunity(jobOpportunity.getTitle(), jobOpportunity.getDescription(),
                    jobOpportunity.getLanguage(), jobOpportunity.getClosingDate(),
                    jobOpportunity.getEducationLevel(), jobOpportunity.getSalary(),
                    jobOpportunity.getCriterion(),
                    jobOpportunity.getCustomer(),getAverage(jobOpportunity));

        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not created");
            throw new IllegalArgumentException("Job Opportunity not created");
        }
    }

    public JobOpportunity editJobOpportunity(JobOpportunity jobOpportunity, long id) {
        closingDay(jobOpportunity);
        if (validate(jobOpportunity).isEmpty() && jobOpportunity.getId() == id) {
            Logger.getLogger(JobOpportunityValidation.class.getName()).info("JobOpportunity edited");
            return new JobOpportunity(jobOpportunity.getTitle(), jobOpportunity.getDescription(),
                    jobOpportunity.getLanguage(), jobOpportunity.getClosingDate(),
                    jobOpportunity.getEducationLevel(), jobOpportunity.getSalary(),
                    jobOpportunity.getCriterion(),
                    jobOpportunity.getCustomer(),getAverage(jobOpportunity));
        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not edited");
            throw new IllegalArgumentException("Job Opportunity not edited");
        }
    }

    private void renewDay(JobOpportunity jobOpportunity) {
        if (jobOpportunity.getClosingDate() == null) {
            closingDay(jobOpportunity);
        }
    }

    public double getAverage(JobOpportunity jobOpportunity) {
        double multiple = 0;
        int soma = 0;
        Set<Criterion> criterion = jobOpportunity.getCriterion();
        for (int i = 0; i < criterion.size(); i++) {
            for (Criterion calculate : criterion) {
                multiple += (calculate.getPmd() * calculate.getWeight());
                soma += calculate.getWeight();
            }
        }
        return jobOpportunity.setMinimumProfile(multiple / soma);
    }

    private void closingDay(JobOpportunity jobOpportunity) {
        jobOpportunity.setClosingDate(LocalDate.now().plusDays(30));
    }

    public boolean isExpired(LocalDate closingDate) {
        if (closingDate.isEqual(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean opportunityExists(Long id) {
        return true;
    }


    public JobOpportunity deleteJobOpportunity(JobOpportunity jobOpportunity, Cpf cpf) {
        if (exitCustomerJobOpportunity(jobOpportunity,cpf)) {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity deleted");
            return jobOpportunity.delete(jobOpportunity.getId());
        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not found");
            throw new IllegalArgumentException("Job Opportunity not found");
        }
    }

    public JobOpportunity customerJobOpportunity(JobOpportunity jobOpportunity,Cpf cpf) {
        if (exitCustomerJobOpportunity(jobOpportunity,cpf)) {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity found");
            return jobOpportunity;
        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not found");
            throw new IllegalArgumentException("Job Opportunity not found");
        }
    }


    public boolean exitCustomerJobOpportunity(JobOpportunity jobOpportunity,Cpf cpf) {
        return jobOpportunity.getCustomer().getCpf().getNumber().equals(cpf.getNumber());
    }


}
