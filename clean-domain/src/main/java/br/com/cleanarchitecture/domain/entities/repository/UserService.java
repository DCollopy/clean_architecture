package br.com.cleanarchitecture.domain.entities.repository;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.domain.entities.User;


public interface UserService {

    void save(User user);

    void saveCurriculum(User user);

    User findOne(Cpf cpf);

    Boolean exist(Cpf cpf);

    User edit(User user, Cpf cpf);

}
