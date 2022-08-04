package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "customer")
public class CustomerEntity extends ProfileEntity implements Serializable {

    private final String type = "CUSTOMER";
    protected CustomerEntity() {}

    public CustomerEntity(String name, String lastName, EmailEntity email, CpfEntity cpf,
                          PhoneEntity phone, FunctionalEntity functional, CompanyEntity company) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }

    @Embedded
    private FunctionalEntity functional;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private JobOpportunityEntity jobOpportunity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private CompanyEntity company;


}
