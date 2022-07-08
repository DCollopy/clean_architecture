package br.com.cleandomain.entities;

import br.com.cleandomain.usecases.validation.ClientValidation;
import br.com.cleandomain.usecases.validation.iusercases.IClientValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    IClientValidation clientValidation = new ClientValidation();

    @Test
    void who() {
        Client client = new Client();
        client.setFunctional(new Functional("111111111"));
        String expected = "111111111";
        String actual = client.who();
        assertEquals(expected, actual);
    }

    @Test
    void getFunctional() {
        Client client = new Client();
        client.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = client.getFunctional().getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void setFunctional() {
        Client client = new Client();
        client.setFunctional(new Functional("123456789"));
        String expected = "123456789";
        String actual = client.getFunctional().getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void notProfileClient() {
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createClient(new Client(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createClient(new Client("Luis",null,new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createClient(new Client("Luis","Oliveira",null,new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createClient(new Client("Luis","Oliveira",new Email("teste@email.com"),null
                        ,new Phone("21", "11111111"),new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createClient(new Client("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,null,new Functional("123456789"))));
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createClient(new Client("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),null)));
    }

    @Test
    void profileClient() {
        Client client = new Client();
        client.setFunctional(new Functional("123456789"));
        client.setName("teste");
        client.setEmail(new Email("teste@email.com"));
        client.setCpf(new Cpf("33333333333"));
        client.setPhone(new Phone("21", "11111111"));
        assertEquals(client, client);
    }
}