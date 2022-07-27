package br.com.cleanweb.model;

import br.com.cleandomain.entities.Profile;
import lombok.Data;

@Data
public class ProfileForm {
    private String name;
    private String lastName;
    private EmailForm email;
    private CpfForm cpf;
    private PhoneForm phone;

    public ProfileForm() {
    }
    public ProfileForm(Profile profile) {
        this.name = profile.getName();
        this.lastName = profile.getLastName();
        this.email = new EmailForm(profile.getEmail());
        this.cpf = new CpfForm(profile.getCpf());
        this.phone = new PhoneForm(profile.getPhone());
    }

}
