package br.com.cleanweb.configs;

import br.com.cleandomain.usecases.validation.IUserValidation;
import br.com.cleanweb.model.UserForm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class UserConfig  {

    private final IUserValidation userValidation;

    public UserConfig(IUserValidation userValidation) {
        this.userValidation = userValidation;
    }

    @Bean
    public void createUser(UserForm userForm){
        userValidation.createUser(userForm.toUser());
    }

    @Bean
    public void createUserCurriculum(UserForm userForm){
        userValidation.createUserCurriculum(userForm.toUserCurriculum());
    }

}
