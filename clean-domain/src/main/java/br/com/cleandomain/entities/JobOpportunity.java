package br.com.cleandomain.entities;

import br.com.cleandomain.entities.ientities.IJobOpportunity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobOpportunity implements IJobOpportunity {
    private String title;
    private String description;
    private String language;
    private String minimumProfile;
    private LocalDate startDate;
    private LocalDate closingDate;
    private String educationLevel;
    private String salary;
    private Criterion criterion;
    private User user;
    private Company company;
    private Client client;
    private boolean status;
}
