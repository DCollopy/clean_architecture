package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "funcional")
public class FunctionalEntity implements Serializable {
    @Column(name = "number", length = 11)
    private String functional;

}
