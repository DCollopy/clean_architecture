package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "cnpj")
public class CnpjEntity implements Serializable {

    @Column(length = 14, nullable = false)
    private String cnpj;
}
