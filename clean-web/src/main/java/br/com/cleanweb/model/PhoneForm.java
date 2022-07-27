package br.com.cleanweb.model;

import lombok.Data;

@Data
public class PhoneForm {

    private String ddd;
    private String number;

    public PhoneForm(Phone phone) {
        this.ddd = phone.getDdd();
        this.number = phone.getNumber();
    }

    public PhoneForm() {
    }

    public br.com.cleandomain.entities.Phone convertPhoneFormToPhone(){
        return new br.com.cleandomain.entities.Phone(this.ddd, this.number);
    }
}
