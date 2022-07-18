package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Admin;
import br.com.cleandomain.entities.repository.IAdmin;

public interface IAdminValidation {
    void validate(IAdmin admin);

    String adminIsAdmin(String cpfAdmin);

    void createAdmin(IAdmin admin);
}
