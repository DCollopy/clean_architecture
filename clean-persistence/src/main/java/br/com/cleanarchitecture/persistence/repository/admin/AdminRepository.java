package br.com.cleanarchitecture.persistence.repository.admin;

import br.com.cleanarchitecture.persistence.entities.AdminEntity;
import br.com.cleanarchitecture.persistence.entities.CpfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, CpfEntity> {
}
