package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.usecases.validation.IJobOpportunityValidation;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class JobOpportunityValidation implements IJobOpportunityValidation {

    public String validate(JobOpportunity jobOpportunity) {
        String message = "";
        if (jobOpportunity.getTitle() == null || jobOpportunity.getTitle().isEmpty()) {
            return "Title is required";
        }
        if (jobOpportunity.getDescription() == null || jobOpportunity.getDescription().isEmpty()) {
            return "Description is required";
        }
        if (jobOpportunity.getCompany() == null) {
            return "Company is required";
        }
        if (jobOpportunity.getCriterion() == null) {
            return "Criterion is required";
        }
        if( jobOpportunity.getCustomer().getCpf() == null || jobOpportunity.getCustomer().getCpf().getNumber().isEmpty()){
            return "CPF is required";
        }
        return message;
    }

    public JobOpportunity createJobOpportunity(JobOpportunity jobOpportunity) {
        if (jobOpportunity.getClosingDate() == null) {
            closingDay(jobOpportunity);
        }
        jobOpportunity.setId(UUID.randomUUID().getMostSignificantBits());
        jobOpportunity.setStatus(true);

        if (validate(jobOpportunity).isEmpty()) {
            Logger.getLogger(JobOpportunityValidation.class.getName()).info("JobOpportunity created");
           return new JobOpportunity(jobOpportunity.getId(), jobOpportunity.getTitle(), jobOpportunity.getDescription(),
                    jobOpportunity.getLanguage(), jobOpportunity.getStartDate(), jobOpportunity.getClosingDate(),
                    jobOpportunity.getEducationLevel(), jobOpportunity.getSalary(),
                    jobOpportunity.getCriterion(),
                    jobOpportunity.getCompany(), jobOpportunity.getCustomer(),getAverage(jobOpportunity));

        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not created");
            throw new IllegalArgumentException("Job Opportunity not created");
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


    public JobOpportunity deleteJobOpportunity(JobOpportunity jobOpportunity) {
        if (jobOpportunity.getId() == 0 || exitCustomerJobOpportunity(jobOpportunity.getCustomer().getCpf())) {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity deleted");
            return jobOpportunity.delete(jobOpportunity.getId());
        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not found");
            throw new IllegalArgumentException("Job Opportunity not found");
        }
    }

    public List<JobOpportunity> listCustomerJobOpportunity(Cpf cpf) {
        JobOpportunity jobOpportunity = new JobOpportunity();
        if (cpf != null) {
            return jobOpportunity.listAllCustomer(cpf);
        }
        Logger.getLogger("JobOpportunityValidation").info("Customer not found job publication");
        return null;
    }

    public boolean exitCustomerJobOpportunity(Cpf cpf) {
        if (cpf != null) {
            return true;
        }
        return false;
    }
}
