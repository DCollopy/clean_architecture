package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.repository.IUser;
import br.com.cleandomain.usecases.validation.iusercases.IUserValidation;

public class UserValidation implements IUserValidation {

    public void createClient(IUser user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is required");
        }
        if (user.getEmail() == null || user.getEmail().getAddress().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (user.getCpf() == null || user.getCpf().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Cpf is required");
        }
        if (user.getPhone() == null || user.getPhone().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone is required");
        }
    }
}
