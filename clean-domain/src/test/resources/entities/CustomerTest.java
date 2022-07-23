package br.com.cleandomain.entities;

import br.com.cleandomain.entities.repository.ICustomer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    ICustomer customer = new Customer();

    @Test
    void who() {
        customer.setFunctional(new Functional("111111111"));
        String expected = "111111111";
        String actual = customer.who();
        assertEquals(expected, actual);
    }

    @Test
    void getFunctional() {
        customer.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = customer.getFunctional().getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void setFunctional() {
        customer.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = customer.getFunctional().getNumber();
        assertEquals(expected, actual);
    }


}