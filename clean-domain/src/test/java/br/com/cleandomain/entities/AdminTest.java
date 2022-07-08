package br.com.cleandomain.entities;

import br.com.cleandomain.usecases.validation.iusercases.AdminValidation;
import br.com.cleandomain.usecases.validation.iusercases.IAdminValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    IAdminValidation adminValidation = new AdminValidation();
    @Test
    void how() {
        Admin admin = new Admin();
        admin.setFunctional(new Functional("111111111"));
        String expected = "111111111";
        String actual = admin.who();
        assertEquals(expected, actual);
    }

    @Test
    void getFunctional() {
        Admin admin = new Admin();
        admin.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = admin.getFunctional().getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void setFunctional() {
        Admin admin = new Admin();
        admin.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = admin.getFunctional().getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void notProfileAdmin() {
        assertThrows(IllegalArgumentException.class,
                () -> adminValidation.validate(new Admin(null, "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> adminValidation.validate(new Admin("Luis", null, new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> adminValidation.validate(new Admin("luis", "Oliveira", null, new Cpf("33333333333"),
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> adminValidation.validate(new Admin("Luis", "Oliveira", new Email("teste@email.com"), null,
                        new Phone("21", "11111111"), new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> adminValidation.validate(new Admin("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        null, new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> adminValidation.validate(new Admin("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                        new Phone("21", "11111111"), null)));

    }

    @Test
    void profileAdmin() {
        Admin admin = new Admin();
        admin.setFunctional(new Functional("123456789"));
        admin.setName("teste");
        admin.setLastName("teste");
        admin.setEmail(new Email("teste@email.com"));
        admin.setCpf(new Cpf("33333333333"));
        admin.setPhone(new Phone("21","11111111"));
        assertEquals(admin, admin);
    }
}