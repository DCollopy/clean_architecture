package br.com.cleanpersistence.entities;

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

    @Embedded
    private FunctionalEntity functional;


    public FunctionalEntity getFunctional() {
        return functional;
    }

    public void setFunctional(FunctionalEntity functional) {
        this.functional = functional;
    }
}
