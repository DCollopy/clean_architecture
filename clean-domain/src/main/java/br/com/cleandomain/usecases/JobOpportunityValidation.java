package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.entities.repository.ICpf;
import br.com.cleandomain.entities.repository.IJobOpportunity;
import br.com.cleandomain.usecases.validation.IJobOpportunityValidation;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class JobOpportunityValidation implements IJobOpportunityValidation {

    public String validate(IJobOpportunity jobOpportunity) {
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

    public void createJobOpportunity(IJobOpportunity jobOpportunity) {
        if (jobOpportunity.getClosingDate() == null) {
            closingDay(jobOpportunity);
        }
        jobOpportunity.setId(UUID.randomUUID().getMostSignificantBits());
        jobOpportunity.setStatus(true);

        if (validate(jobOpportunity).isEmpty()) {
            new JobOpportunity(jobOpportunity.getId(), jobOpportunity.getTitle(), jobOpportunity.getDescription(),
                    jobOpportunity.getLanguage(), jobOpportunity.getStartDate(), jobOpportunity.getClosingDate(),
                    jobOpportunity.getEducationLevel(), jobOpportunity.getSalary(),
                    jobOpportunity.getCriterion(),
                    jobOpportunity.getCompany(), jobOpportunity.getCustomer(),getAverage(jobOpportunity));
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity created");
        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not created");
        }

    }

    public double getAverage(IJobOpportunity jobOpportunity) {
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

    private void closingDay(IJobOpportunity jobOpportunity) {
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


    public void deleteJobOpportunity(IJobOpportunity jobOpportunity) {
        if (jobOpportunity.getId() == 0 || exitCustomerJobOpportunity(jobOpportunity.getCustomer().getCpf())) {
            jobOpportunity.delete(jobOpportunity.getId());
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity deleted");
        } else {
            Logger.getLogger("JobOpportunityValidation").info("Job Opportunity not found");
        }
    }

    public List<IJobOpportunity> listCustomerJobOpportunity(ICpf cpf) {
        IJobOpportunity jobOpportunity = new JobOpportunity();
        if (cpf != null) {
            return jobOpportunity.listAllCustomer(cpf);
        }
        Logger.getLogger("JobOpportunityValidation").info("Customer not found job publication");
        return null;
    }

    public boolean exitCustomerJobOpportunity(ICpf cpf) {
        if (cpf != null) {
            return true;
        }
        return false;
    }
}
