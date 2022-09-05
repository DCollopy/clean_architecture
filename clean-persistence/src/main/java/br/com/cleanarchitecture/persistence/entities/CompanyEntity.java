package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
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

    public CompanyEntity(CnpjEntity cnpj, String fantasyName) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
    }

    public CompanyEntity(Set<CustomerEntity> customer) {
        this.customer = customer;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Company_Custommer",
            joinColumns = @JoinColumn(name = "company_cnpj"),
            inverseJoinColumns = @JoinColumn(name = "customer_cpf"))
    private Set<CustomerEntity> customer = new HashSet<>();

}
