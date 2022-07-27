package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.User;

public interface IUserValidation {
    String validate(User user);
    String takeCpf(User user);
    String userIsUser(String cpfUser);
    User createUser(User user);
    User createUserCurriculum(User user);
}
