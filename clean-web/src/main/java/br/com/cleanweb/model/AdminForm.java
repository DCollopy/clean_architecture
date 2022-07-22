package br.com.cleanweb.model;

import br.com.cleandomain.entities.repository.IAdmin;
import br.com.cleandomain.entities.repository.IProfile;
import lombok.Data;

@Data
public class AdminForm  extends ProfileForm{
    private FunctionalForm functional;

    public AdminForm(IAdmin admin, IProfile profile) {
        super(profile);
        this.functional = new FunctionalForm(admin.getFunctional());
    }

    public AdminForm(IAdmin admin) {
        this.functional = new FunctionalForm(admin.getFunctional());
    }
}
