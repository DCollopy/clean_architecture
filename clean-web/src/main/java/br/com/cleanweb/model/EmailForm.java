package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.IEmail;
import lombok.Data;

@Data
public class EmailForm {

    private String address;

    public EmailForm(IEmail email) {
        this.address = email.getAddress();
    }
}
