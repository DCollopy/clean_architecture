package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "company")
public class CompanyEntity implements Serializable {

    @EmbeddedId
    private CnpjEntity cnpj;
    @Column(length = 100)
    private String fantasyName;

    public CompanyEntity() {}

    public CompanyEntity(CnpjEntity cnpj, String fantasyName, Set<CustomerEntity> customers) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
        this.customer = customers;
    }

    public CompanyEntity(Set<CustomerEntity> customer) {
        this.customer = customer;
    }


    @ManyToOne(cascade = CascadeType.PERSIST)
    private JobOpportunityEntity jobOpportunity;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name="Company_Custommer",joinColumns=
            {@JoinColumn(name="company_id",referencedColumnName="cnpj")},
            inverseJoinColumns={@JoinColumn(name="customer_id",referencedColumnName="cpf")})
    private Set<CustomerEntity> customer = new HashSet<>();

}
