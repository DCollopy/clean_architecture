package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.persistence.entities.AnswerOpportunityEntity;

import java.util.stream.Collectors;

public class AnswerOpportunityConverter {

//    public AnswerOpportunity AnswerOpportunityEntityToAnswerOpportunity(AnswerOpportunityEntity answerOpportunity) {
//       return new AnswerOpportunity(answerOpportunity.getPmdUser().stream().map(PointsConverter::pointsEntityToPoints).collect(Collectors.toSet()),
//               new JobOpportunityConverter().jobOpportunityEntityListToJobOpportunitySet(answerOpportunity.getJobOpportunityEntities()),
//               new UserConverter().convertToUserSet(answerOpportunity.getUserEntity()),
//               answerOpportunity.getMinimumProfile());
//    }
//
//    public AnswerOpportunityEntity answerOpportunityToAnswerOpportunityEntity(AnswerOpportunity answerOpportunity) {
//        return new AnswerOpportunityEntity(answerOpportunity.getPmdUser().stream().map(PointsConverter::pointsToPointsEntity).collect(Collectors.toSet()),
//                new JobOpportunityConverter().jobOpportunitySetToJobOpportunityEntitySet(answerOpportunity.getJobOpportunity()),
//                new UserConverter().convertToUserEntitySet(answerOpportunity.getUser()),
//                answerOpportunity.getMinimumProfile());
//    }
}
