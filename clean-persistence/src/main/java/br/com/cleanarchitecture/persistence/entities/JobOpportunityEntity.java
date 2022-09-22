package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "jobOpportunity")
public class JobOpportunityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String title;

    @Column(length = 100)
    private String description;

    @Column(length = 100)
    private String language;

    private Double minimumProfile = 0.0;
    private final LocalDate startDate = LocalDate.now();

    private LocalDate closingDate;

    private boolean status;

    @Column(length = 100)
    private String educationLevel;
    private String salary;

    protected JobOpportunityEntity() {}

    public JobOpportunityEntity(long id,String title, String description, String language,
                                LocalDate closingDate, String educationLevel,
                                String salary,CustomerEntity customer,Double minimumProfile) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.language = language;
        this.closingDate = closingDate;
        this.educationLevel = educationLevel;
        this.salary = salary;
        this.customer = customer;
        this.minimumProfile = minimumProfile;
    }

    public JobOpportunityEntity(AnswerOpportunityEntity answerOpportunity) {
        this.answerOpportunity = answerOpportunity;
    }

    public JobOpportunityEntity(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    private CustomerEntity customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answerOopportunity_user")
    private AnswerOpportunityEntity answerOpportunity;

}
