package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.AnswerOpportunity;
import br.com.cleandomain.entities.Criterion;
import br.com.cleandomain.entities.repository.ICriterion;

public class CriterionValidation {

    public void validate(ICriterion criterion) {
        if (criterion.getTitle() == null) {
            throw new IllegalArgumentException("Criterion title is required");
        }
        if (criterion.getDescription() == null) {
            throw new IllegalArgumentException("Criterion description is required");
        }
        if (criterion.getPmd() < 1 || criterion.getPmd() > 5) {
            throw new IllegalArgumentException("Criterion pmd is required");
        }
        if (criterion.getWeight() < 1 || criterion.getWeight() > 5) {
            throw new IllegalArgumentException("Criterion weight is required");
        }
    }

    // (pmd * weight) + (pmd * weight) + (pmd * weight)/ weight + weight + weight = moderateAverage
   public double calculateMultiple(ICriterion criterion) {
        // (pmd*weight) /(weight) = moderateAverage
        return (criterion.getPmd() * criterion.getWeight());
    }

    public double calculateSum(ICriterion criterion) {
        int sum = 0;
        return sum =+ criterion.getWeight();
    }

    public double calculateAverage(ICriterion criterion) {
        return  calculateMultiple(criterion)/calculateSum(criterion);
    }

    public void answerValidation(ICriterion criterion, long id) {
       if(criterion.getId() == id) {
           AnswerOpportunity answerOpportunity =
                   new AnswerOpportunity(id,criterion.getAnswerOpportunity().getPmdUser(),criterion.getAnswerOpportunity().getWeightUser());
              answerOpportunity.setCriterion((Criterion) criterion);
              criterion.setAnswerOpportunity(answerOpportunity);
       }
    }
}


