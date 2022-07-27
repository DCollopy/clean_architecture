package br.com.cleanweb.model;

import br.com.cleandomain.entities.Email;
import br.com.cleandomain.entities.repository.IEmail;
import lombok.Data;

@Data
public class EmailForm implements IEmail {

    private String address;

    public EmailForm(IEmail email) {
        this.address = email.getAddress();
    }

    public EmailForm() {
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {}

    public Email convertEmailFormToEmail(){
        return new Email(this.getAddress());
    }

}
