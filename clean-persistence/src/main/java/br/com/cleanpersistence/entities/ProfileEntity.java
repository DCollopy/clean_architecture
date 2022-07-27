package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@Table(name = "profile")
public class ProfileEntity implements Serializable {

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
