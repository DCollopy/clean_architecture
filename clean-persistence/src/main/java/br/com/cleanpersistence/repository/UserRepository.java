package br.com.cleanpersistence.repository;


import br.com.cleanpersistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    UserEntity findByCpf(String cpf);
}