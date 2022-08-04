package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "admin")
public class AdminEntity extends ProfileEntity implements Serializable {

    private final String type = "ADMIN";

    @Embedded
    private FunctionalEntity functional;


    public FunctionalEntity getFunctional() {
        return functional;
    }

    public void setFunctional(FunctionalEntity functional) {
        this.functional = functional;
    }
}
