package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.Points;

import java.util.*;
import java.util.logging.Logger;

public abstract class AnswerOpportunityValidation  {

    public String validate(AnswerOpportunity answerOpportunity) {
        if(answerOpportunity.getUser() == null) {
            return "User is required";
        }
        if(answerOpportunity.getJobOpportunity() == null) {
            return "Job Opportunity is required";
        }
        return "";
    }

    public AnswerOpportunity createAnswerOpportunity(AnswerOpportunity answerOpportunity, String whoYou) {
        if(validate(answerOpportunity).isEmpty() && answerOpportunity.getUser().who().equals(whoYou)) {
            Logger.getLogger(AnswerOpportunityValidation.class.getName()).info("AnswerOpportunity created");
            return new AnswerOpportunity(answerOpportunity.getPmdUser(),answerOpportunity.getJobOpportunity(),
                    answerOpportunity.getUser(),getAverage(answerOpportunity));
        }else {
            throw new IllegalArgumentException("Ops!!!, something went wrong");
        }
    }

    public double getAverage(AnswerOpportunity answerOpportunity) {
        double multiple = 0;
        int soma = 0;
        Set<Criterion> criterion = answerOpportunity.getJobOpportunity().stream().iterator().next().getCriterion();
        for (int i = 0; i < criterion.size(); i++) {
            for (Criterion calculate : criterion) {
                for(Points pmdUser : answerOpportunity.getPmdUser()) {
                    multiple += (pmdUser.getPmdUser() * calculate.getWeight());
                    soma += calculate.getWeight();
                }
            }
        }
        return answerOpportunity.setMinimumProfile(multiple / soma);
    }

    public Set<JobOpportunity> listAllJobOpportunity(JobOpportunity jobOpportunity, AnswerOpportunity answerOpportunity) {
        for (JobOpportunity job : answerOpportunity.getJobOpportunity()) {
            if (job.getId() == jobOpportunity.getId()) {
                return answerOpportunity.getJobOpportunity();
            }
        }
        return Collections.emptySet();
    }

    public AnswerOpportunity minimunProfileIsClosedJobMinimumProfile(AnswerOpportunity answerOpportunity, JobOpportunity jobOpportunity) {
        if(answerOpportunity.getMinimumProfile() >= jobOpportunity.getMinimumProfile()) {
            return answerOpportunity;
        }
        return null;
    }
}
