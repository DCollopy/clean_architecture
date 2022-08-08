package br.com.cleanarchitecture.persistence.repository.company;

import br.com.cleanarchitecture.persistence.entities.CnpjEntity;
import br.com.cleanarchitecture.persistence.entities.CompanyEntity;
import br.com.cleanarchitecture.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, CnpjEntity> {

}
