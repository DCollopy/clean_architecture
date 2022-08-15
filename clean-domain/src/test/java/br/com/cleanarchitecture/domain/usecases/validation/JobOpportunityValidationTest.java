package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.*;
import br.com.cleanarchitecture.domain.entities.repository.IEducationLevel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JobOpportunityValidationTest {

    protected JobOpportunityValidTest jobOpportunityValidation = new JobOpportunityValidTest();

    private JobOpportunity getJobOpportunity(Set<Criterion> criterion, Cpf cpf) {
        JobOpportunity jobOpportunity = new JobOpportunity("Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                new Customer("Joao","Oliveira",new Email("teste@email.com"), cpf
                        ,new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")));
        return jobOpportunity;
    }

    private Set<Criterion> getCriteria() {
        Set<Criterion> criterion = new HashSet<>();
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"UML","O candidato deverá conhecer os principais diagramasda UML: casos de uso, classes e seqüência",4,5));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"Ingles","Conversação e leitura de documentos técnicos",4,3));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"Análise de Pontos de Função","Desejável conhecimentos de dimensionamento de sistemas",1,1));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"Experiência Profissional","2 anos de experiência em levantamento de requisitos análise.",4,2));
        return criterion;
    }


    @Test
    void validate() {
        Set<Criterion> criterion = getCriteria();
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity("",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Customer(null, "Oliveira", new Email("teste@email.com"), new Cpf("33333333333")
                                , new Phone("21", "11111111"), new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"), "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));

        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity(null,
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",criterion,
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity("Engenheiro de Software Java Pleno",
                        "",
                        "English intemediario", LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity("Engenheiro de Software Java Pleno",
                        null,
                        "English intemediario", LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity("Engenheiro de Software Java Pleno",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
        assertNotNull(jobOpportunityValidation.validate(new JobOpportunity("Engenheiro de Software Java Pleno",
                        "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                        "English intemediario", LocalDate.now().plusDays(30),
                        IEducationLevel.COMPLETE_GRAD, "1200",
                        null,
                        new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333")
                                ,new Phone("21", "11111111"),new Functional("123456789"),
                                new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")))));
    }



    @Test
    void createJobOpportunity() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = getJobOpportunity(criterion, new Cpf("33333333333"));
        assertEquals(jobOpportunity,jobOpportunityValidation.createJobOpportunity(jobOpportunity,"CUSTOMER"));
    }

    @Test
    void notCreateJobOpportunityNotCustomer() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = getJobOpportunity(criterion, new Cpf("33333333333"));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.createJobOpportunity(jobOpportunity, "ADMIN"));
    }



    @Test
    void notCreateJobOpportunityCriterioNull() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = getJobOpportunity(criterion, null);
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.createJobOpportunity(jobOpportunity, "CUSTOMER"));
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
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = getJobOpportunity(criterion, new Cpf("33333333333"));
        assertFalse(jobOpportunityValidation.exitCustomerJobOpportunity(jobOpportunity,new Cpf("11111111111")));
    }

    @Test
    void customerExist() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = getJobOpportunity(criterion, new Cpf("33333333333"));
        assertTrue(jobOpportunityValidation.exitCustomerJobOpportunity(jobOpportunity,new Cpf("33333333333")));
    }

    @Test
    void customerJobOpportunity() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = getJobOpportunity(criterion, new Cpf("33333333333"));
        assertEquals(jobOpportunity,jobOpportunityValidation.customerJobOpportunity(jobOpportunity,jobOpportunity.getCustomer().getCpf()));
    }

    @Test
    void deleteNotFoundCustomer() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = new JobOpportunity("Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", criterion,
                new Customer(null,"Oliveira",new Email("teste@email.com"),new Cpf("33333333333"),
                        new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")));
        assertThrows(IllegalArgumentException.class,
                () -> jobOpportunityValidation.deleteJobOpportunity(jobOpportunity, new Cpf("11111111111")));
    }

    @Test
    void delete() {
        Set<Criterion> criterion = getCriteria();
        JobOpportunity jobOpportunity = new JobOpportunity(UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200",criterion,
                new Customer("Jose","Oliveira",new Email("teste@email.com"),
                        new Cpf("33333333333")
                        ,new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO")));
        assertNotNull(jobOpportunityValidation.deleteJobOpportunity(jobOpportunity,new Cpf("33333333333")));
    }

}