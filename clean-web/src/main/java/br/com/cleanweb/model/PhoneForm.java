package br.com.cleanweb.model;

import br.com.cleandomain.entities.Phone;
import br.com.cleandomain.entities.repository.IPhone;
import lombok.Data;

@Data
public class PhoneForm {

    private String ddd;
    private String number;

    public PhoneForm(IPhone phone) {
        this.ddd = phone.getDdd();
        this.number = phone.getNumber();
    }

    public PhoneForm() {
    }

    public Phone convertPhoneFormToPhone(){
        return new Phone(this.ddd, this.number);
    }
}
