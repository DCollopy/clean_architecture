package br.com.cleandomain.usecases.validation.iusercases;

import br.com.cleandomain.entities.User;
import br.com.cleandomain.entities.repository.IUser;

public interface IUserValidation {
    void validate(IUser user);
    String takeCpf(IUser user);
    String userIsUser(String cpfUser);
    User createUser(IUser user);
    User createUserCurriculum(IUser user);
}
