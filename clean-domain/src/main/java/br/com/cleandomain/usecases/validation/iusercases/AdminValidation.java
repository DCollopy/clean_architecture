package br.com.cleandomain.usecases.validation.iusercases;

import br.com.cleandomain.entities.repository.IAdmin;

public class AdminValidation implements IAdminValidation {

    @Override
    public void validate(IAdmin admin) {
        if(admin.getName() == null || admin.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if(admin.getLastName() == null || admin.getLastName().isEmpty()) {
            throw new IllegalArgumentException("LastName is required");
        }
        if(admin.getEmail() == null || admin.getEmail().getAddress().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if(admin.getCpf() == null || admin.getCpf().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Cpf is required");
        }
        if(admin.getPhone() == null || admin.getPhone().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone is required");
        }
        if(admin.getFunctional() == null || admin.getFunctional().getNumber().isEmpty()) {
            throw new IllegalArgumentException("Functional is required");
        }
    }
}
