package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.Admin;
import br.com.cleandomain.entities.repository.IAdmin;
import br.com.cleandomain.usecases.validation.iusercases.IAdminValidation;

import java.util.logging.Logger;

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

    // a ideia aqui e jogar o cpf vindo da jpa para esse metodo
    public String adminIsAdmin(String cpfAdmin){
        if(cpfAdmin == null || cpfAdmin.isEmpty()) {
            Logger.getLogger(AdminValidation.class.getName()).info("Cpf is not admin");
        }
        return cpfAdmin;
    }
    // so posso chamar esse metodo depois de validar o cpf
    public Admin createAdmin(IAdmin admin) {
        Logger.getLogger(AdminValidation.class.getName()).info("Admin created");
        return new Admin(admin.getName(), admin.getLastName(), admin.getEmail(),
                admin.getCpf(), admin.getPhone(), admin.getFunctional());
    }

}
