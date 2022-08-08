package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.Admin;
import br.com.cleanarchitecture.domain.entities.Cpf;

import java.util.logging.Logger;

public abstract class AdminValidation {


    public String validate(Admin admin) {
        String message = "";
        if(admin.getName() == null || admin.getName().isEmpty()) {
            return "Name is required";
        }
        if(admin.getLastName() == null || admin.getLastName().isEmpty()) {
            return "Last name is required";
        }
        if(admin.getEmail() == null || admin.getEmail().getAddress().isEmpty()) {
            return "Email is required";
        }
        if(admin.getCpf() == null || admin.getCpf().getNumber().isEmpty()) {
            return "CPF is required";
        }
        if(admin.getPhone() == null || admin.getPhone().getNumber().isEmpty()) {
            return "Phone is required";
        }
        if(admin.getFunctional() == null || admin.getFunctional().getNumber().isEmpty()) {
            return "Functional is required";
        }
        return message;
    }


    public boolean adminIsAdmin(String admin) {
        return new Admin().getType().equals(admin);
    }

    public Admin createAdmin(Admin admin, String whoYou) {
        if(validate(admin).isEmpty() && adminIsAdmin(whoYou)) {
            Logger.getLogger(AdminValidation.class.getName()).info("Admin created");
            return new Admin(admin.getName(), admin.getLastName(), admin.getEmail(),
                    admin.getCpf(), admin.getPhone(), admin.getFunctional());
        }
        throw new IllegalArgumentException("Admin does not create");

    }

    public Admin updateAdmin(Admin admin, Cpf cpf, String whoYou) {
        if (cpf.equals(admin.getCpf()) && validate(admin).isEmpty() && adminIsAdmin(whoYou)) {
            Logger.getLogger(AdminValidation.class.getName()).info("Admin updated");
            return new Admin(admin.getName(), admin.getLastName(), admin.getEmail(),
                    admin.getCpf(), admin.getPhone(), admin.getFunctional());
        }
        throw new IllegalArgumentException("Admin does not update");
    }

}
