package br.com.cleanarchitecture.persistence.repository.customer;

import br.com.cleanarchitecture.persistence.entities.CpfEntity;
import br.com.cleanarchitecture.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, CpfEntity> {

    Optional<CustomerEntity> findByUuid(String uuid);

}
