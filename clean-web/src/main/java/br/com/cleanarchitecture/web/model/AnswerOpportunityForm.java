package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.AnswerOpportunity;
import br.com.cleanarchitecture.domain.entities.JobOpportunity;
import br.com.cleanarchitecture.domain.entities.User;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class AnswerOpportunityForm {
    private long id;
    private Set<PointsForm> pmdUser;
    private User user;
    private Set<JobOpportunity> jobOpportunity;
    private double minimumProfile;

    public AnswerOpportunityForm(AnswerOpportunity answerOpportunity) {
        this.id = answerOpportunity.getId();
        this.pmdUser = answerOpportunity.getPmdUser().stream().map(PointsForm::new).collect(Collectors.toSet());
        this.minimumProfile = answerOpportunity.getMinimumProfile();
        this.jobOpportunity = answerOpportunity.getJobOpportunity();
        this.user = answerOpportunity.getUser();
    }

    public AnswerOpportunityForm() {}

    public AnswerOpportunity answerOpportunityFormToAnswer() {
        return new AnswerOpportunity(getPmdUser().stream().map(PointsForm:: pointsFormToPoints).collect(Collectors.toSet()),
                getJobOpportunity(), getUser(), getMinimumProfile());
    }

}
