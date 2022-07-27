package br.com.cleanweb.model;

import br.com.cleandomain.entities.Email;
import lombok.Data;

@Data
public class EmailForm {

    private String address;

    public EmailForm(Email email) {
        this.address = email.getAddress();
    }

    public EmailForm() {
    }


    public String getAddress() {
        return this.address;
    }


    public void setAddress(String address) {}

    public br.com.cleandomain.entities.Email convertEmailFormToEmail(){
        return new br.com.cleandomain.entities.Email(this.getAddress());
    }

}
