package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.entities.repository.IEducationLevel;
import br.com.cleandomain.entities.repository.IJobOpportunity;
import br.com.cleandomain.usecases.JobOpportunityValidation;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JobOpportunityValidationTest {

    protected IJobOpportunityValidation jobOpportunityValidation = new JobOpportunityValidation();

    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        new Criterion(UUID.randomUUID().getMostSignificantBits(), "Java","teste",4,5),
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),null,
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        new Criterion(UUID.randomUUID().getMostSignificantBits(), "Java","teste",4,5),
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        "",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        new Criterion(UUID.randomUUID().getMostSignificantBits(), "Java","teste",4,5),
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        null,
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        new Criterion(UUID.randomUUID().getMostSignificantBits(), "Java","teste",4,5),
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        new Criterion(UUID.randomUUID().getMostSignificantBits(), "Java","teste",4,5),
                        null,
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));

        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        new Criterion(UUID.randomUUID().getMostSignificantBits(), "Java","teste",4,5),
                        new Company(new Cnpj(null),
                                null),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        null,
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
    }

    @Test
    void createJobOpportunity() {
        IJobOpportunity jobOpportunity = new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                 "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200",
                new Criterion(UUID.randomUUID().getMostSignificantBits(), "Java","teste",4,5),
                new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")));
        jobOpportunityValidation.createJobOpportunity(jobOpportunity);
    }

    @Test
    void isExpired() {
        LocalDate closingDate = LocalDate.now();
        assertTrue(jobOpportunityValidation.isExpired(closingDate));
    }

    @Test
    void closingDay(){
        LocalDate closingDate = LocalDate.now().plusDays(30);
        assertFalse(jobOpportunityValidation.isExpired(closingDate));
    }


    @Test
    void opportunityExists() {
        assertTrue(jobOpportunityValidation.opportunityExists(UUID.randomUUID().getMostSignificantBits()));
    }

}