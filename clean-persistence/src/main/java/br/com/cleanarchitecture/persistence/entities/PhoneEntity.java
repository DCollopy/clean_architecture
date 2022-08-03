package br.com.cleanarchitecture.persistence.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Data
@Table(name = "phone")
public class PhoneEntity {
    protected PhoneEntity() {
    }

    public PhoneEntity(String ddd,String phone) {;
        this.ddd = ddd;
        this.phone = phone;
    }
    @Column(length = 2)
    private String ddd;
    @Column(length = 11)
    private String phone;


}
