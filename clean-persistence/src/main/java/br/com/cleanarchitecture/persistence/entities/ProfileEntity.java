package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@Table(name = "profile")
public class ProfileEntity implements Serializable {

    public ProfileEntity(String name, String lastName, EmailEntity email, CpfEntity cpf,  PhoneEntity phone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
    }
    protected ProfileEntity() {
    }

    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String lastName;
    @EmbeddedId
    private CpfEntity cpf;
    @Embedded
    private EmailEntity email;
    @Embedded
    private PhoneEntity phone;


}
