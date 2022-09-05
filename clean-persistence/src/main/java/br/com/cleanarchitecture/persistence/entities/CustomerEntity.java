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

    @Column(length = 500)
    private String uuid;

    private final String type = "CUSTOMER";

    protected CustomerEntity() {}

    public CustomerEntity(String uuid,String name, String lastName, EmailEntity email, CpfEntity cpf,
                          PhoneEntity phone, FunctionalEntity functional,CompanyEntity company) {
        super(name, lastName, email, cpf, phone);
        this.uuid = uuid;
        this.functional = functional;
        this.company = company;
    }
    public CustomerEntity(String name, String lastName, EmailEntity email, CpfEntity cpf,
                          PhoneEntity phone, FunctionalEntity functional) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }

    public CustomerEntity(Set<JobOpportunityEntity> jobOpportunity) {
        this.jobOpportunity = jobOpportunity;
    }

    @Embedded
    private FunctionalEntity functional;

    @OneToMany(mappedBy = "customer")
    private Set<JobOpportunityEntity> jobOpportunity = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Company_Custommer",
            joinColumns = @JoinColumn(name = "customer_cpf"),
            inverseJoinColumns = @JoinColumn(name = "company_cnpj"))
    private CompanyEntity company;

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }


}
