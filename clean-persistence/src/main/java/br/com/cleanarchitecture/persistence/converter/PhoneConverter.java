package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Phone;
import br.com.cleanarchitecture.persistence.entities.PhoneEntity;

public class PhoneConverter {


    public PhoneConverter() {
    }

    public PhoneEntity convertToPhoneEntity(String ddd, String number) {
        return new PhoneEntity(ddd, number);
    }

    public Phone convertToPhone(String ddd, String number) {
        return new Phone(ddd, number);
    }
}
