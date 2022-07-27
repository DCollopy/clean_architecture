package br.com.cleanweb.service;

import br.com.cleanweb.model.UserForm;

public interface UserService {

    void save(UserForm user);

    void saveCurriculum(UserForm userForm);
}
