package br.com.cleanarchitecture.persistence.repository.user;


import br.com.cleanarchitecture.persistence.entities.CpfEntity;
import br.com.cleanarchitecture.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, CpfEntity> {
    Optional<UserEntity> findByUuid(String uid);

}