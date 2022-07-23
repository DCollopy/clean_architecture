package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.repository.IAdmin;

public interface IAdminValidation {
    String validate(IAdmin admin);

    String adminIsAdmin(String cpfAdmin);

    IAdmin createAdmin(IAdmin admin);
}
