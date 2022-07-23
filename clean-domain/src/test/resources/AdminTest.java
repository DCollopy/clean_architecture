package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.IAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminTest {

    IAdmin admin = new Admin();
    @Test
    void how() {
        admin.setFunctional(new Functional("111111111"));
        String expected = "111111111";
        String actual = admin.who();
        assertEquals(expected, actual);
    }

    @Test
    void getFunctional() {
        admin.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = admin.getFunctional().getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void setFunctional() {
        admin.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = admin.getFunctional().getNumber();
        assertEquals(expected, actual);
    }


}