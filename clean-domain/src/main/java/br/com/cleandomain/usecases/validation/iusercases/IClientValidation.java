package br.com.cleandomain.usecases.validation.iusercases;

import br.com.cleandomain.entities.repository.IClient;

public interface IClientValidation {
    void createClient(IClient client);
}
