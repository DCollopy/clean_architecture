package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@Data
@Table(name = "email")
public class EmailEntity implements Serializable {

    private String address;
}
