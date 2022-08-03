package br.com.cleanarchitecture.persistence.repository;


import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    UserEntity findByCpf(Cpf cpf);
}