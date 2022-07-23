package br.com.cleandomain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CpfTest {

    @Test
    void getNumber() {
        Cpf cpf = new Cpf("12345678901");
        assertEquals("12345678901", cpf.getNumber());
    }

    @Test
    void setNumber() {
        Cpf cpf = new Cpf("12345678901");
        cpf.setNumber("98765432109");
        assertEquals("98765432109", cpf.getNumber());
    }

    @Test
    void testEquals() {
        Cpf cpf = new Cpf("12345678901");
        Cpf cpf2 = new Cpf("12345678901");
        assertEquals(cpf, cpf2);
    }

    @Test
    void testHashCode() {
        Cpf cpf = new Cpf("12345678901");
        Cpf cpf2 = new Cpf("12345678901");
        assertEquals(cpf.hashCode(), cpf2.hashCode());
    }
    @Test
    void notCreateCpfInvalid(){
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Cpf(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("123456"));

    }

    @Test
    void shouldCreateCpf(){
        String number = "368.592.968-28";
        Cpf cpf = new Cpf(number);

        assertEquals(number,cpf.getNumber());

    }
}