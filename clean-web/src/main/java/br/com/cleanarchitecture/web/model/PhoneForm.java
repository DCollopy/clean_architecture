package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Phone;
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

    public Phone convertPhoneFormToPhone(String ddd, String number) {
        return new Phone(ddd, number);
    }
}
