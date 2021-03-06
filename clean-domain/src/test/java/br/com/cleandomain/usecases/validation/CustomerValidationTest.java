package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.usecases.CustomerValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerValidationTest {
    ICustomerValidation clientValidation = new CustomerValidation();

    @Test
    void customerTeamCompany() {
        Customer customer = new br.com.cleandomain.entities.Customer("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                new Phone("21","11111111"), new Functional("123456789"), new Company(new Cnpj("33.663.683/0001-16"),
                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"));
        assertTrue(clientValidation.customerTeamCompany(customer));
    }

    @Test
    void notCustomerTeamCompany() {
        Customer customer = new br.com.cleandomain.entities.Customer("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                new Phone("21","11111111"), new Functional("123456789"), null);
        assertFalse(clientValidation.customerTeamCompany(customer));
    }

    @Test
    void notProfileClient() {
        assertNotNull(clientValidation.validate(new br.com.cleandomain.entities.Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new br.com.cleandomain.entities.Customer("Luis",null,new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull( clientValidation.validate(new br.com.cleandomain.entities.Customer("Luis","Oliveira",null,new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new br.com.cleandomain.entities.Customer("Luis","Oliveira",new Email("teste@email.com"),null
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new br.com.cleandomain.entities.Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,null,new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new br.com.cleandomain.entities.Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),null, new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.validate(new br.com.cleandomain.entities.Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj(null),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new br.com.cleandomain.entities.Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),null))));
    }

    @Test
    void profileCreateClient() {
        Customer client = new br.com.cleandomain.entities.Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"));
        assertEquals(client,clientValidation.createCustomer(client));
    }

    @Test
    void profileNotCreateClient() {
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createCustomer(new br.com.cleandomain.entities.Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
    }
}