package br.com.cleanweb.configs;

import br.com.cleandomain.entities.repository.IUser;
import br.com.cleandomain.usecases.validation.IUserValidation;
import br.com.cleanweb.model.UserForm;

public class UserConfig {

    private final IUserValidation userValidation;

    public UserConfig(IUserValidation userValidation) {
        this.userValidation = userValidation;
    }

    public void createUser(UserForm userForm){
        userValidation.createUser((IUser) userForm);
    }
}
