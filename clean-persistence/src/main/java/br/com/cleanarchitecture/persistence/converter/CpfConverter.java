package br.com.cleanarchitecture.persistence.converter;

import br.com.cleanarchitecture.domain.entities.Cpf;
import br.com.cleanarchitecture.persistence.entities.CpfEntity;
import org.springframework.stereotype.Service;

@Service
public class CpfConverter {

    public CpfConverter() {
    }

    public CpfEntity convertToCpfEntity(String cpf) {
        return new CpfEntity(cpf);
    }

    public Cpf convertToCpf(String cpf) {
        return new Cpf(cpf);
    }
}
