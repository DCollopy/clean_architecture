package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "company")
public class CompanyEntity implements Serializable {

    @EmbeddedId
    private CnpjEntity cnpj;
    @Column(length = 100)
    private String fantasyName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private JobOpportunityEntity jobOpportunity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private CustomerEntity customer;

}
