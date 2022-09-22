package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.Criterion;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.User;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class AnswerOpportunityForm {
    private long id;
    private Set<PointsForm> pmdUser;
    private long user;
    private long jobOpportunity;
    private double minimumProfile;


    public AnswerOpportunityForm() {}

    public AnswerOpportunity answerOpportunityFormToAnswer(List<Criterion> criterionList, User user) {
        return new AnswerOpportunity(getPmdUser().stream().map(PointsForm:: pointsFormToPoints).collect(Collectors.toSet()),
                new CriterionForm().convertToCriterionList(criterionList),
                new UserForm().convertToUser(user), getMinimumProfile());
    }

}
