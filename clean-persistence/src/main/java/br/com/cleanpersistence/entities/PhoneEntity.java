package br.com.cleanpersistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Data
@Table(name = "phone")
public class PhoneEntity {

    @Column(length = 2)
    private String ddd;
    @Column(length = 11)
    private String phone;


}
