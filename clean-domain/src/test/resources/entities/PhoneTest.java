package br.com.cleandomain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneTest {
    @Test
    void naoDeveriaCriarTelefoneComDDDsInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone(null, "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("", "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("1", "123456789"));
    }

    @Test
    void notShouldCreateTelephoneWithInvalidNumbers() {
        assertThrows(IllegalArgumentException.class,
                () -> new Phone(null, null));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("", ""));

        assertThrows(IllegalArgumentException.class,
                () -> new Phone("1", "1234"));
    }

    @Test
    void shouldCreatePhoneComDDDsNumber(){
        String ddd = "21";
        String number = "123456789";
        Phone phone = new Phone(ddd,number);
        assertEquals(ddd,phone.getDdd());
        assertEquals(number,phone.getNumber());
    }

}