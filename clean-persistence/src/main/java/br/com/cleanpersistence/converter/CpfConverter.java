package br.com.cleanpersistence.converter;

import br.com.cleandomain.entities.Cpf;
import br.com.cleanpersistence.entities.CpfEntity;
import org.springframework.stereotype.Service;

@Service
public class CpfConverter {

    public Cpf convertToCpf() {
        CpfEntity cpfEntity = new CpfEntity();
        return new Cpf(cpfEntity.getCpf());
    }
}
