package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.Admin;

public interface IAdminValidation {
    String validate(Admin admin);

    String adminIsAdmin(String cpfAdmin);

    Admin createAdmin(Admin admin);
}
