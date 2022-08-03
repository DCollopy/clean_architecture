package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "job_opportunity")
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

    @Column(length = 100)
    private String educationLevel;
    private String salary;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CriterionEntity> criterion;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<UserEntity> user;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CompanyEntity> company;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CustomerEntity> customer;

    private boolean status;

}
