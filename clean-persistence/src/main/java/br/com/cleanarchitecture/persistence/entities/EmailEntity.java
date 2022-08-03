package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "email")
public class EmailEntity implements Serializable {
    public EmailEntity(String address) {
        this.address = address;
    }

    protected EmailEntity() {
    }
    private String address;


}
