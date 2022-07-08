package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.ientities.IClient;
import br.com.cleandomain.usecases.validation.iusercases.IClientValidation;

public class ClientValidation implements IClientValidation {

    @Override
    public void createClient(IClient client) {
        if(client.getName() == null || client.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if(client.getLastName() == null || client.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is required");
        }
        if(client.getEmail() == null || client.getEmail().getAddress().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if(client.getCpf() == null || client.getCpf().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Cpf is required");
        }
        if(client.getPhone() == null || client.getPhone().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone is required");
        }
        if(client.getFunctional() == null || client.getFunctional().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Functional is required");
        }
    }


}
