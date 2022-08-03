package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.User;

public interface IUserValidation {
    String validate(User user);
    String takeCpf(User user);
    String userIsUser(String cpfUser);
    User createUser(User user);
    User createUserCurriculum(User user);
}
