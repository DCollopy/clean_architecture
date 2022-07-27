package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Admin;

public interface IAdminValidation {
    String validate(Admin admin);

    String adminIsAdmin(String cpfAdmin);

    Admin createAdmin(Admin admin);
}
