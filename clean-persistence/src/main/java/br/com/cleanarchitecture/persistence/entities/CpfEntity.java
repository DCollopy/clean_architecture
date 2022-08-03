package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "cpf")
public class CpfEntity implements Serializable {
    protected CpfEntity() {
    }

    public CpfEntity(String cpf) {
        this.cpf = cpf;
    }
    @Column(length = 11, nullable = false)
    private String cpf;
}
