package br.com.cleanarchitecture.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    Admin admin = new Admin();
    @Test
    void how() {
        String expected = admin.getType();;
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