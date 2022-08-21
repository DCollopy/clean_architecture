package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.persistence.entities.AnswerOpportunityEntity;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnswerOpportunityConverter {
    public AnswerOpportunity answerOpportunityEntityToAnswerOpportunity(AnswerOpportunityEntity answerOpportunityEntity) {
        return new AnswerOpportunity(answerOpportunityEntity.getPmdUser().stream().map(PointsConverter::pointsEntityToPoints).collect(Collectors.toSet()),
                 new JobOpportunityConverter().jobOpportunityEntitySetToJobOpportunitySet(answerOpportunityEntity.getJobOpportunityEntities()),
                 new UserConverter().convertToUser(answerOpportunityEntity.getUserEntity()),
                answerOpportunityEntity.getMinimumProfile());
    }

    public AnswerOpportunityEntity answerOpportunityToAnswerOpportunityEntity(AnswerOpportunity answerOpportunity) {
        return new AnswerOpportunityEntity(answerOpportunity.getPmdUser().stream().map(PointsConverter::pointsToPointsEntity).collect(Collectors.toSet()),
                 new JobOpportunityConverter().jobOpportunitySetToJobOpportunityEntitySet(answerOpportunity.getJobOpportunity()),
                 new UserConverter().convertToUserEntity(answerOpportunity.getUser()),
                 answerOpportunity.getMinimumProfile());
    }

    public List<AnswerOpportunity> answerOpportunityEntityListToAnswerOpportunityList(List<AnswerOpportunityEntity> answerOpportunityEntityList) {
        return answerOpportunityEntityList.stream().map(this::answerOpportunityEntityToAnswerOpportunity).collect(Collectors.toList());
    }

    public Set<AnswerOpportunity> answerOpportunityEntityListToAnswerOpportunitySet(Set<AnswerOpportunityEntity> answerOpportunityEntityList) {
        return answerOpportunityEntityList.stream().map(this::answerOpportunityEntityToAnswerOpportunity).collect(Collectors.toSet());
    }

}
