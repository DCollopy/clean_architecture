package br.com.cleanarchitecture.domain.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void notCreateInvalidEmail(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("emailinvalido"));

    }

    @Test
    void shouldCreateEmail(){
        String address = "teste@email.com";
        Email email = new Email(address);
        assertEquals(address,email.getAddress());
    }

}