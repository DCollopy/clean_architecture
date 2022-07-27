package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.entities.repository.IEducationLevel;
import br.com.cleandomain.usecases.UserValidation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;
;
import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {
    IUserValidation userValidation = new UserValidation();

    @Test
    void validate() {
        assertNotNull( userValidation.validate(new User(null, "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"))));
        assertNotNull(userValidation.validate(new User("Luis", null, new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"))));
        assertNotNull(userValidation.validate(new User("luis", "Oliveira", null,
                new Cpf("33333333333"), new Phone("21", "11111111"))));
        assertNotNull(userValidation.validate(new User("Luis", "Oliveira", new Email("teste@email.com"),
                null, new Phone("21", "11111111"))));
        assertNotNull(userValidation.validate(new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), null)));
    }

    @Test
    void takeCpf() {
        User user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"));
        assertEquals(user.getCpf().getNumber(), userValidation.takeCpf(user));
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
        User user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"));
        assertEquals(user,userValidation.createUser(user));
    }

    @Test
    void createUserCurriculum() {
        User user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"),
                new SchoolingLevel(UUID.randomUUID().getMostSignificantBits(),"Software Engineer", IEducationLevel.COMPLETE_GRAD, LocalDate.now(), LocalDate.now()),
                new Skill(UUID.randomUUID().getMostSignificantBits(), "Java"),
                new ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(), "IBM", "Data Science", "Data analysis about systems support",
                        LocalDate.of(2000, 05, 02), LocalDate.now()));
        assertEquals(user,userValidation.createUserCurriculum(user));
    }
}