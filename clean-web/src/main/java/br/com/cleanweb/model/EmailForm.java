package br.com.cleanweb.model;

import lombok.Data;

@Data
public class EmailForm implements Email {

    private String address;

    public EmailForm(Email email) {
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

    public br.com.cleandomain.entities.Email convertEmailFormToEmail(){
        return new br.com.cleandomain.entities.Email(this.getAddress());
    }

}
