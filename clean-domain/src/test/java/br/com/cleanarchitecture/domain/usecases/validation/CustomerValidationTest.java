package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerValidationTest {
    CustomerValidTest clientValidation = new CustomerValidTest();

    @Test
    void customerTeamCompany() {
        Customer customer = new Customer("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                new Phone("21","11111111"), new Functional("123456789"), new Company(new Cnpj("33.663.683/0001-16"),
                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"));
        assertTrue(clientValidation.customerTeamCompany(customer));
    }

    @Test
    void notCustomerTeamCompany() {
        Customer customer = new Customer("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                new Phone("21","11111111"), new Functional("123456789"), null);
        assertFalse(clientValidation.customerTeamCompany(customer));
    }

    @Test
    void notProfileClient() {
        assertNotNull(clientValidation.validate(new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new Customer("Luis",null,new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull( clientValidation.validate(new Customer("Luis","Oliveira",null,new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new Customer("Luis","Oliveira",new Email("teste@email.com"),null
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,null,new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),null, new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.validate(new Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj(null),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        assertNotNull(clientValidation.validate(new Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),null))));
    }

    @Test
    void profileCreateClient() {
        Customer client = new Customer("Luis","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"));
        assertEquals(client,clientValidation.createCustomer(client));
    }

    @Test
    void profileNotCreateClient() {
        assertThrows(IllegalArgumentException.class,
                () -> clientValidation.createCustomer(new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
    }

    @Test
    void custumerIsCustumer(){
        Customer customer = new Customer("Luis", "Oliveira", new Email("teste@email.com"), new Cpf("33333333333"),
                new Phone("21","11111111"), new Functional("123456789"), new Company(new Cnpj("33.663.683/0001-16"),
                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"));
        assertTrue(clientValidation.custumerIsCustumer(customer));
    }
}