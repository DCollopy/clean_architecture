package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminValidationTest {

    protected AdminValidTest adminValidation = new AdminValidTest();
    @Test
    void notProfileAdmin() {
        assertNotNull(adminValidation.validate(new Admin(null, "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertNotNull(adminValidation.validate(new Admin("Luis", null, new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertNotNull(adminValidation.validate(new Admin("luis", "Oliveira", null, new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertNotNull(adminValidation.validate(new Admin("Luis", "Oliveira", new Email("teste@email.com"), null,
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertNotNull(adminValidation.validate(new Admin("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        null, new Functional("123456789"))));
        assertNotNull(adminValidation.validate(new Admin("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), null)));

    }

    @Test
    void profileIsAdmin(){
        Admin admin = new Admin("Pedro", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                new Phone("21", "11111111"), new Functional("123456789"));
        assertTrue(adminValidation.adminIsAdmin(admin.getType()));
    }

    @Test
    void profileNotCreateAdmin() {
        assertThrows(IllegalArgumentException.class, () -> adminValidation.createAdmin(
                new Admin(null, "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789")),"ADMIN"));
    }

    @Test
    void profileCreateAdmin() {
        String whoYou = "ADMIN";
        assertNotNull(adminValidation.createAdmin(
                new Admin("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789")), whoYou));
    }

}