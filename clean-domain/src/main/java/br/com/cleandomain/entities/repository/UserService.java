package br.com.cleandomain.entities.repository;

import br.com.cleandomain.entities.User;

public interface UserService {

    void save(User user);

    void saveCurriculum(User user);
}
