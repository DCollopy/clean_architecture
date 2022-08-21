package br.com.cleanarchitecture.domain.usecases.validation;

import br.com.cleanarchitecture.domain.entities.*;
import br.com.cleanarchitecture.domain.entities.repository.IEducationLevel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AnswerOpportunityValidationTest {

    protected AnswerOpportunityValidTest answerOpportunityValidation = new AnswerOpportunityValidTest();

    private Set<Criterion> getCriteria() {
        Set<Criterion> criterion = new HashSet<>();
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"UML","O candidato deverá conhecer os principais diagramasda UML: casos de uso, classes e seqüência",4,5));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"Ingles","Conversação e leitura de documentos técnicos",4,3));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"Análise de Pontos de Função","Desejável conhecimentos de dimensionamento de sistemas",1,1));
        criterion.add(new Criterion(UUID.randomUUID().getMostSignificantBits(),"Experiência Profissional","2 anos de experiência em levantamento de requisitos análise.",4,2));
        return criterion;
    }

    private Set<JobOpportunity> getJobOpportunity() {
        Set<JobOpportunity> jobOpportunity = new HashSet<>();

        jobOpportunity.add(new JobOpportunity( 1L,"Engenheiro de Software C#",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", getCriteria(),
                new Customer("Joao","Oliveira",new Email("teste@email.com"),
                        new Cpf("12345678901"),
                        new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));

        jobOpportunity.add(new JobOpportunity( UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software Python",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", getCriteria(),
                new Customer("Joao","Oliveira",new Email("teste@email.com"),
                        new Cpf("12345678901"),
                        new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));

        jobOpportunity.add(new JobOpportunity( UUID.randomUUID().getMostSignificantBits(),"Engenheiro de Software FullStack",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", getCriteria(),
                new Customer("Joao","Oliveira",new Email("teste@email.com"),
                        new Cpf("12345678901"),
                        new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))));
        return jobOpportunity;
    }

    private User getUser() {
       return new User("Luis", "Oliveira", new Email("teste@email.com"),
               new Cpf("33333333333"), new Phone("21", "11111111"));
    }

    private Set<Points> getPmdUser() {
        Set<Points> pmdUser = new HashSet<>();
        pmdUser.add(new Points(5));
        pmdUser.add(new Points(3));
        pmdUser.add(new Points(1));
        pmdUser.add(new Points(5));
        return pmdUser;
    }


    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class,
                () -> answerOpportunityValidation.validate(new AnswerOpportunity(new HashSet<>(0,0),getJobOpportunity() ,getUser())));
        assertThrows(IllegalArgumentException.class,
                () -> answerOpportunityValidation.validate(new AnswerOpportunity(getPmdUser(),getJobOpportunity(),null)));
    }

    @Test
    void createAnswerOpportunity() {
        AnswerOpportunity answerOpportunity = new AnswerOpportunity(getPmdUser(),getJobOpportunity(), getUser());
        assertEquals(answerOpportunity, answerOpportunityValidation.createAnswerOpportunity(answerOpportunity,"USER"));
    }

    @Test
    void getAverage() {
        AnswerOpportunity answerOpportunity = new AnswerOpportunity(getPmdUser(),getJobOpportunity(), getUser());
        assertEquals(3.0, answerOpportunityValidation.getAverage(answerOpportunity));
    }

    @Test
    void listAllJobOpportunity() {
        AnswerOpportunity answerOpportunity = new AnswerOpportunity(getPmdUser(),getJobOpportunity(), getUser());
        assertEquals(answerOpportunity.getJobOpportunity(), answerOpportunityValidation.listAllJobOpportunity(new JobOpportunity(1L,"Engenheiro de Software Java Pleno",
                "Entre para a melhor empresa de tecnologia do mercado, aplique seus conhecmentos em ferramentas de ponta",
                "English intemediario", LocalDate.now().plusDays(30),
                IEducationLevel.COMPLETE_GRAD, "1200", getCriteria(),
                new Customer("Joao","Oliveira",new Email("teste@email.com"),
                        new Cpf("12345678901"),
                        new Phone("21", "11111111"),new Functional("123456789"),
                        new Company(new Cnpj("33.663.683/0001-16"),"UNIVERSIDADE FEDERAL DO RIO DE JANEIRO"))),
                answerOpportunity));
    }
}