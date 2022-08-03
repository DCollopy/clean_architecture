package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Email;
import br.com.cleanarchitecture.persistence.entities.EmailEntity;
import lombok.Data;

@Data
public class EmailConverter {

    public EmailConverter() {
    }

    public EmailEntity convertToEmailEntity(String address) {
        return new EmailEntity(address);
    }

    public Email convertToEmail(String address) {
        return new Email(address);
    }

}
