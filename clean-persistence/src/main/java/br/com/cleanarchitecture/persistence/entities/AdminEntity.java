package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "admin")
public class AdminEntity extends ProfileEntity implements Serializable {

    @Column(length = 500)
    private String uuid;

    private final String type = "ADMIN";

    @Embedded
    private FunctionalEntity functional;

    public AdminEntity(String name, String lastName, EmailEntity email, CpfEntity cpf, PhoneEntity phone, FunctionalEntity functional) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }

    public AdminEntity(FunctionalEntity functional) {
        this.functional = functional;
    }

    protected AdminEntity() {}
    public FunctionalEntity getFunctional() {
        return functional;
    }

}
