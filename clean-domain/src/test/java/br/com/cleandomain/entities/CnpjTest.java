package br.com.cleandomain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CnpjTest {

    @Test
    void getNumero() {
        Cnpj cnpj = new Cnpj("12345678901234");
        assertEquals("12345678901234", cnpj.getNumber());
    }

    @Test
    void setNumero() {
        Cnpj cnpj = new Cnpj("12345678901234");
        cnpj.setNumber("98765432109876");
        assertEquals("98765432109876", cnpj.getNumber());
    }

    @Test
    void testEquals() {
        Cnpj cnpj = new Cnpj("12345678901234");
        Cnpj cnpj2 = new Cnpj("12345678901234");
        assertEquals(cnpj, cnpj2);
    }

    @Test
    void testHashCode() {
        Cnpj cnpj = new Cnpj("12345678901234");
        Cnpj cnpj2 = new Cnpj("12345678901234");
        assertEquals(cnpj.hashCode(), cnpj2.hashCode());
    }

    @Test
    void notCreateCnpjInvalid(){
        assertThrows(IllegalArgumentException.class,
                () -> new Cnpj(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Cnpj(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Cnpj("123456"));

    }

    @Test
    void shouldCreateCnpj(){
        String numero = "11.111.111/0001-11";
        Cnpj cnpj = new Cnpj(numero);

        assertEquals(numero,cnpj.getNumber());

    }

}