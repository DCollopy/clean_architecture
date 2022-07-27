package br.com.cleanpersistence.converter;

import br.com.cleandomain.entities.Phone;
import br.com.cleanpersistence.entities.PhoneEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PhoneConverter {

    public Phone convertToPhone() {
        PhoneEntity phoneEntity = new PhoneEntity();
        return new Phone(phoneEntity.getDdd(), phoneEntity.getPhone());
    }
}
