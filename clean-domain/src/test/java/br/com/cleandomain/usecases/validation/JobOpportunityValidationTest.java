package br.com.cleandomain.usecases.validation;

import br.com.cleandomain.entities.*;
import br.com.cleandomain.entities.repository.ICpf;
import br.com.cleandomain.entities.repository.IEducationLevel;
import br.com.cleandomain.entities.repository.IJobOpportunity;
import br.com.cleandomain.usecases.JobOpportunityValidation;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JobOpportunityValidationTest {

    protected IJobOpportunityValidation jobOpportunityValidation = new JobOpportunityValidation();

    private IJobOpportunity getJobOpportunity(Set<Criterion> criterion, Cpf cpf) {
        IJobOpportunity jobOpportunity = new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                new Customer("Joao","Oliveira",new Email("teste@email.com"), cpf
                        ,new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")));
        return jobOpportunity;
    }
    private Set<Criterion> getCriteria() {
        Set<Criterion> criterion = new HashSet<>();
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),
                "UML","O candidato deverá conhecer os principais diagramasda UML: casos de uso, classes e seqüência",4,5));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),
                "Ingles","Conversação e leitura de documentos técnicos",4,3));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),
                "Análise de Pontos de Função","Desejável conhecimentos de dimensionamento de sistemas",1,1));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),
                "Experiência Profissional","2 anos de experiência em levantamento de requisitos análise.",4,2));
        return criterion;
    }
    @Test
    void validate() {
        Set<Criterion> criterion = getCriteria();
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(), "",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null, "Oliveira", new Email("teste@email.com"), new Cpf("33333333333")
                                , new Phone("21", "11111111"), new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"), "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),null,
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",criterion,
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        "",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        null,
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Company(new Cnpj("33.663.683/0001-16"),
                                "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        null,
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));

        assertThrows(IllegalArgumentException.class,
                () ->jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Company(new Cnpj(null),
                                null),
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
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
        Set<Criterion> criterion = getCriteria();
        IJobOpportunity jobOpportunity = getJobOpportunity(criterion, new Cpf("33333333333"));
        assertEquals(jobOpportunity,jobOpportunityValidation.createJobOpportunity(jobOpportunity));
    }



    @Test
    void notCreateJobOpportunity() {
        Set<Criterion> criterion = getCriteria();
        IJobOpportunity jobOpportunity = getJobOpportunity(criterion, null);
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.createJobOpportunity(jobOpportunity));
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

    @Test
    void customerNotExist() {
        assertFalse(jobOpportunityValidation.exitCustomerJobOpportunity(null));
    }

    @Test
    void customerExist() {
        ICpf cpf = new Cpf("33333333333");
        assertTrue(jobOpportunityValidation.exitCustomerJobOpportunity(cpf));
    }

    @Test
    void listCustomerJobOpportunity() {
        ICpf cpf = new Cpf("33333333333");
        assertTrue(jobOpportunityValidation.listCustomerJobOpportunity(cpf).size() > 0);
    }

    @Test
    void deleteNotFoundCustomer() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                new Company(new Cnpj("33.663.683/0001-16"), "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                new Customer(null,"Oliveira",new Email("teste@email.com"),null
                        ,new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.deleteJobOpportunity(jobOpportunity));
    }

    @Test
    void delete() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now(), LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200",criterion,
                new Company(new Cnpj("33.663.683/0001-16"),
                        "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"),
                new Customer("Jose","Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")));
        assertNotNull(jobOpportunityValidation.deleteJobOpportunity(jobOpportunity));
    }

}