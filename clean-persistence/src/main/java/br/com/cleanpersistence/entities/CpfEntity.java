package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "cpf")
public class CpfEntity implements Serializable {

    @Column(length = 11, nullable = false)
    private String cpf;
}
