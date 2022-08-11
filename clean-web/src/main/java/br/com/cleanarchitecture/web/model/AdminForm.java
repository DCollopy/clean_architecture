package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Profile;
import lombok.Data;

@Data
public class AdminForm  extends ProfileForm{
    private FunctionalForm functional;
    private final String type = "ADMIN";

    public AdminForm(Admin admin, Profile profile) {
        super(profile);
        this.functional = new FunctionalForm(admin.getFunctional());
    }

    public AdminForm(){}

    public AdminForm(Admin admin) {
        this.functional = new FunctionalForm(admin.getFunctional());
    }

    public String who() {
        return this.getType();
    }

    public Admin convertAdminformToAdmin() {
        Admin admin = new Admin(
                this.getName(), this.getLastName(),
                new EmailForm().convertEmailFormToEmail(this.getEmail().getAddress()),
                new CpfForm().convertCpfFormToCpf(this.getCpf().getNumber()),
                new PhoneForm().convertPhoneFormToPhone(this.getPhone().getDdd(), this.getPhone().getNumber()),
                new FunctionalForm().convertFunctionalToFunctional(this.getFunctional().getNumber()));
        return admin;
    }
}
