package br.com.cleanarchitecture.domain.usecases;

import br.com.cleanarchitecture.domain.entities.Admin;

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

    // a ideia aqui e jogar o cpf vindo da jpa para esse metodo
    public String adminIsAdmin(String cpfAdmin){
        if(cpfAdmin == null || cpfAdmin.isEmpty()) {
            Logger.getLogger(AdminValidation.class.getName()).info("Cpf is not admin");
        }
        return cpfAdmin;
    }

    public Admin createAdmin(Admin admin) {
        if(validate(admin).isEmpty()) {
            Logger.getLogger(AdminValidation.class.getName()).info("Admin created");
            return new Admin(admin.getName(), admin.getLastName(), admin.getEmail(),
                    admin.getCpf(), admin.getPhone(), admin.getFunctional());
        }
        throw new IllegalArgumentException("Admin does not create");

    }

}
