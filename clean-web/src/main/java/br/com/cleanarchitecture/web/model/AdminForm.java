package br.com.cleanarchitecture.web.model;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Profile;
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
