package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
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
    private LocalDate startDate;

    private LocalDate closingDate;

    private boolean status;

    @Column(length = 100)
    private String educationLevel;
    private String salary;

    protected JobOpportunityEntity() {}

    public JobOpportunityEntity(String title, String description, String language,
                                LocalDate closingDate, String educationLevel,
                                String salary, Set<CriterionEntity> criterion,
                                CustomerEntity customer,Double minimumProfile) {
        this.title = title;
        this.description = description;
        this.closingDate = closingDate;
        this.educationLevel = educationLevel;
        this.salary = salary;
        this.criterion = criterion;
        this.customer = customer;
        this.minimumProfile = minimumProfile;


    }

    @OneToMany(mappedBy = "jobOpportunity")
    private Set<CriterionEntity> criterion = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Job_Users",joinColumns= {@JoinColumn(name="job_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id",referencedColumnName="cpf")})
    private Set<UserEntity> user = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    private CustomerEntity customer;

}
