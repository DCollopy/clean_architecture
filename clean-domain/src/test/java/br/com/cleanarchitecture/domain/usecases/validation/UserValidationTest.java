package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.*;
import br.com.cleanarchitecture.domain.entities.repository.IEducationLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;
;
import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {

    UserValidTest userValidation = new UserValidTest();

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
        assertNotNull(userValidation.validate(new User("Luis", "Oliveira", null,
                new Cpf("33333333333"), new Phone("21", "11111111"))));
    }

    @Test
    void takeCpf() {
        User user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"));
        Assertions.assertEquals(user.getCpf().getNumber(), userValidation.takeCpf(user));
    }

    @Test
    void userIsUser() {
        String cpf = "33333333333";
        Assertions.assertEquals(cpf, userValidation.userIsUser(cpf));
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
        Assertions.assertEquals(user,userValidation.createUser(user));
    }

    @Test
    void createUserCurriculum() {
        User user = new User("Luis", "Oliveira", new Email("teste@email.com"),
                new Cpf("33333333333"), new Phone("21", "11111111"),
                new SchoolingLevel(UUID.randomUUID().getMostSignificantBits(),"Software Engineer", IEducationLevel.COMPLETE_GRAD, LocalDate.now(), LocalDate.now()),
                new Skill(UUID.randomUUID().getMostSignificantBits(), "Java"),
                new ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(), "IBM", "Data Science", "Data analysis about systems support",
                        LocalDate.of(2000, 05, 02), LocalDate.now()));
        Assertions.assertEquals(user,userValidation.createUserCurriculum(user));
    }
}