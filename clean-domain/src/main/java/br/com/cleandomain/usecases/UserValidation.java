package br.com.cleandomain.usecases;

import br.com.cleandomain.entities.ProfessionalExperience;
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

    public IUser createUser(IUser user) {
        if(validate(user).isEmpty()){
            Logger.getLogger(UserValidation.class.getName()).info("User created");
            return new User(user.getName(), user.getLastName(), user.getEmail(),
                    user.getCpf(), user.getPhone());
        } else{
            Logger.getLogger(UserValidation.class.getName()).info("User not created");
        }
        throw new IllegalArgumentException("User not created");
    }

    public IUser createUserCurriculum(IUser user) {
        if(validate(user).isEmpty()) {
            Logger.getLogger(UserValidation.class.getName()).info("User created curriculum");
            return new User(user.getName(), user.getLastName(), user.getEmail(),
                    user.getCpf(), user.getPhone(), user.getSchoolingLevel(), user.getSkill(),user.getProfessionalExperience());
        } else{
            Logger.getLogger(UserValidation.class.getName()).info("User not created curriculum");
            throw new IllegalArgumentException("User not created curriculum");
        }
    }

    public void userAnswerOpportunity(IUser user) {
        Logger.getLogger(UserValidation.class.getName()).info("User answer opportunity");
        new User(user.getAnswerOpportunity());
    }


}
