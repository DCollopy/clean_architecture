package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.entities.repository.IUser;
import br.com.cleandomain.usecases.validation.iusercases.IUserValidation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {
    IUserValidation userValidation = new UserValidation();

    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class,
                () -> userValidation.validate(new User(null, "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"))));
        assertThrows(IllegalArgumentException.class, () -> userValidation.validate(new User("Luis", null, new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"))));
        assertThrows(IllegalArgumentException.class, () -> userValidation.validate(new User("luis", "Oliveira", null,
                new Cpf("33333333333"),new Phone("21", "11111111"))));
        assertThrows(IllegalArgumentException.class, () -> userValidation.validate(new User("Luis", "Oliveira", new Email("teste@email.com"),
                null, new Phone("21", "11111111"))));
        assertThrows(IllegalArgumentException.class, () -> userValidation.validate(new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), null)));
    }

    @Test
    void takeCpf() {
        IUser user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"));
        assertEquals(user.getCpf().getNumber(),userValidation.takeCpf(user));
    }

    @Test
    void userIsUser() {
        String cpf = "33333333333";
        assertEquals(cpf, userValidation.userIsUser(cpf));
    }

    @Test
    void notUser() {
        String cpf = "";
        assertThrows(IllegalArgumentException.class, () -> userValidation.userIsUser(cpf));
    }

    @Test
    void createUser() {
        IUser user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"));
        assertEquals(user, userValidation.createUser(user));
    }

    @Test
    void createUserCurriculum() {
        IUser user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"),
                new SchoolingLevel("Software Engineer", LocalDate.now(),LocalDate.now()),
                new Skill("Java"),
                new ProfessionalExperience("IBM","Data Science","Data analysis about systems support",
                        LocalDate.of(2000,05,02),LocalDate.now()));
        assertEquals(user, userValidation.createUserCurriculum(user));
    }


}