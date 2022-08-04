package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
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

    public CompanyEntity(CnpjEntity cnpj, String fantasyName) {
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private JobOpportunityEntity jobOpportunity;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<CustomerEntity> customer;

}
