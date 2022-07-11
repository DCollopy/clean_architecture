package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.User;
import br.com.cleandomain.entities.repository.IUser;
import br.com.cleandomain.usecases.validation.iusercases.IUserValidation;

import java.util.logging.Logger;

public class UserValidation implements IUserValidation {

    public void validate(IUser user) {
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

    public String takeCpf(IUser user) {
        return user.getCpf().getNumber();
    }

    public String userIsUser(String cpfUser) {
        if (cpfUser == null || cpfUser.isEmpty()) {
            throw new IllegalArgumentException("Cpf is not user");
        }
        return cpfUser;
    }

    public User createUser(IUser user) {
        Logger.getLogger(UserValidation.class.getName()).info("Creating user");
        return new User(user.getName(), user.getLastName(), user.getEmail(),
                user.getCpf(), user.getPhone());
    }

    public User createUserCurriculum(IUser user) {
        Logger.getLogger(UserValidation.class.getName()).info("User created curriculum");
        return new User(user.getName(), user.getLastName(), user.getEmail(),
                user.getCpf(), user.getPhone(),user.getSchoolingLevel(),user.getSkill(),user.getProfessionalExperience());
    }

}
