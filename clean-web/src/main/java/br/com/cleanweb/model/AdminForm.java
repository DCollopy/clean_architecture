package br.com.cleanweb.model;

import br.com.cleandomain.entities.Admin;
import br.com.cleandomain.entities.Profile;
import lombok.Data;

@Data
public class AdminForm  extends ProfileForm{
    private FunctionalForm functional;

    public AdminForm(Admin admin, Profile profile) {
        super(profile);
        this.functional = new FunctionalForm(admin.getFunctional());
    }

    public AdminForm(Admin admin) {
        this.functional = new FunctionalForm(admin.getFunctional());
    }
}
