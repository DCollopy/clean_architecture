package br.com.cleanpersistence.converter;

import br.com.cleandomain.entities.Email;
import br.com.cleanpersistence.entities.EmailEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailConverter {

    public Email convertToEmail() {
        EmailEntity emailEntity = new EmailEntity();
        return new Email(emailEntity.getAddress());
    }
}
