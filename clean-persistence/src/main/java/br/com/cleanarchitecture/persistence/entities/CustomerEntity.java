package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "customer")
public class CustomerEntity extends ProfileEntity implements Serializable {

    private final String type = "CUSTOMER";

    protected CustomerEntity() {}

    public CustomerEntity(String name, String lastName, EmailEntity email, CpfEntity cpf,
                          PhoneEntity phone, FunctionalEntity functional,Set<CompanyEntity> company) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
        this.company = company;
    }
    public CustomerEntity(String name, String lastName, EmailEntity email, CpfEntity cpf,
                          PhoneEntity phone, FunctionalEntity functional) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }

    public CustomerEntity(Set<CompanyEntity> company) {
        this.company = company;
    }

    @Embedded
    private FunctionalEntity functional;

    @OneToMany(mappedBy = "customer")
    private Set<JobOpportunityEntity> jobOpportunity = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Company_Custommer",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<CompanyEntity> company = new LinkedHashSet<>();

    public Set<CompanyEntity> getCompany() {
        return company;
    }

    public void setCompany(Set<CompanyEntity> company) {
        this.company = company;
    }


}
