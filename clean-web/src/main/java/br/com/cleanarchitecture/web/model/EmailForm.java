package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Email;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmailForm {
    @JsonProperty(value = "email")
    private String address;

    public EmailForm(Email email) {
        this.address = email.getAddress();
    }

    public EmailForm() {
    }

    public Email convertEmailFormToEmail(String address) {
        return new Email(address);
    }

}
