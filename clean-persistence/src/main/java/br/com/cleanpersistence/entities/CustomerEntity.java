package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "customer")
public class CustomerEntity extends ProfileEntity implements Serializable {

    @Embedded
    private FunctionalEntity functional;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private JobOpportunityEntity jobOpportunity;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CompanyEntity> company;
}
