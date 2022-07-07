package br.com.cleandomain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void how() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        String expected = "teste";
        String actual = admin.how();
        assertEquals(expected, actual);
    }

    @Test
    void getFunctional() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        String expected = "teste";
        String actual = admin.getFunctional();
        assertEquals(expected, actual);
    }

    @Test
    void setFunctional() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        String expected = "teste";
        String actual = admin.getFunctional();
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        Admin admin2 = new Admin();
        admin2.setFunctional("teste");
        boolean expected = true;
        boolean actual = admin.equals(admin2);
        assertEquals(expected, actual);
    }

    @Test
    void canEqual() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        boolean expected = true;
        boolean actual = admin.canEqual(admin);
        assertEquals(expected, actual);
    }

    @Test
    void testHashCode() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        int expected = 0;
        int actual = admin.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        String expected = "Admin{functional='teste'}";
        String actual = admin.toString();
        assertEquals(expected, actual);
    }

    @Test
    void profileAdmin() {
        Admin admin = new Admin();
        admin.setFunctional("teste");
        admin.setName("teste");
        admin.setEmail("teste");
        admin.setCpf(new Cpf("33333333333"));
        admin.setPhone(new Phone("21","11111111"));
        assertEquals(admin, admin);
    }
}