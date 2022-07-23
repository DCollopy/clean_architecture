package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.User;
import br.com.cleandomain.entities.repository.IUser;

public interface IUserValidation {
    String validate(IUser user);
    String takeCpf(IUser user);
    String userIsUser(String cpfUser);
    IUser createUser(IUser user);
    IUser createUserCurriculum(IUser user);
}
