package br.com.cleanarchitecture.persistence.service.user;

import br.com.cleanarchitecture.domain.entities.User;
import br.com.cleanarchitecture.domain.usecases.UserValidation;
import org.springframework.stereotype.Service;
@Service
public class UserValidationAbs extends UserValidation {

    public UserValidationAbs() {
        super();
    }
    public User createUser(User user) {
        return super.createUser(user);
    }

    public User createUserCurriculum(User user) {
        return super.createUserCurriculum(user);
    }
}
