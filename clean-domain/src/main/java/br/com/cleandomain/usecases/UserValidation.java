package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.User;
import br.com.cleandomain.entities.repository.IUser;
import br.com.cleandomain.usecases.validation.IUserValidation;

import java.util.logging.Logger;

public class UserValidation implements IUserValidation {

    public String validate(IUser user) {
        String message = "";
        if (user.getName() == null || user.getName().isEmpty()) {
            return "Name is required";
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            return "Last name is required";
        }
        if (user.getEmail() == null || user.getEmail().getAddress().isEmpty()) {
            return "Email is required";
        }
        if (user.getCpf() == null || user.getCpf().getNumber().isEmpty()) {
            return "Cpf is required";
        }
        if (user.getPhone() == null || user.getPhone().getNumber().isEmpty()) {
            return "Phone is required";
        }
        return message;
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

    public void createUser(IUser user) {
        if(validate(user).isEmpty()){
            new User(user.getName(), user.getLastName(), user.getEmail(),
                    user.getCpf(), user.getPhone());
            Logger.getLogger(UserValidation.class.getName()).info("User created");
        } else{
            Logger.getLogger(UserValidation.class.getName()).info("User not created");
        }
    }

    public void createUserCurriculum(IUser user) {
        Logger.getLogger(UserValidation.class.getName()).info("User created curriculum");
        new User(user.getName(), user.getLastName(), user.getEmail(),
                user.getCpf(), user.getPhone(),user.getSchoolingLevel(),user.getSkill(),user.getProfessionalExperience());
    }

    public void userAnswerOpportunity(IUser user) {
        Logger.getLogger(UserValidation.class.getName()).info("User answer opportunity");
        new User(user.getAnswerOpportunity());
    }


}
