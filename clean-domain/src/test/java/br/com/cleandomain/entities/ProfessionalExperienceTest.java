package br.com.cleandomain.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionalExperienceTest {
    ProfessionalExperience professionalExperience = new br.com.cleandomain.entities.ProfessionalExperience();

    @Test
    void getCompanyName() {
        professionalExperience.setCompanyName("Company Name");
        String expected = "Company Name";
        String actual = professionalExperience.getCompanyName();
        assertEquals(expected, actual);
    }

    @Test
    void getFunction() {
        professionalExperience.setFunction("Function");
        String expected = "Function";
        String actual = professionalExperience.getFunction();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        professionalExperience.setDescription("Description");
        String expected = "Description";
        String actual = professionalExperience.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getStartDate() {
        professionalExperience.setStartDate(LocalDate.now());
        LocalDate expected = LocalDate.now();
        LocalDate actual = professionalExperience.getStartDate();
        assertEquals(expected, actual);
    }

    @Test
    void getEndDate() {
        professionalExperience.setEndDate(LocalDate.now());
        LocalDate expected = LocalDate.now();
        LocalDate actual = professionalExperience.getEndDate();
        assertEquals(expected, actual);
    }

    @Test
    void setCompanyName() {
        professionalExperience.setCompanyName("Company Name");
        String expected = "Company Name";
        String actual = professionalExperience.getCompanyName();
        assertEquals(expected, actual);
    }

    @Test
    void setFunction() {
        professionalExperience.setFunction("Function");
        String expected = "Function";
        String actual = professionalExperience.getFunction();
        assertEquals(expected, actual);
    }

    @Test
    void setDescription() {
        professionalExperience.setDescription("Description");
        String expected = "Description";
        String actual = professionalExperience.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void setStartDate() {
        professionalExperience.setStartDate(LocalDate.now());
        LocalDate expected = LocalDate.now();
        LocalDate actual = professionalExperience.getStartDate();
        assertEquals(expected, actual);
    }

    @Test
    void setEndDate() {
        professionalExperience.setEndDate(LocalDate.now());
        LocalDate expected = LocalDate.now();
        LocalDate actual = professionalExperience.getEndDate();
        assertEquals(expected, actual);
    }

    @Test
    void getCompanyNameNull(){
        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(), null, "Product Owner",
                "Directs the course of development, discusses possibilities and limits with the client, evaluates the fulfillment...",
                LocalDate.of(2000,10,05), LocalDate.of(2001,10,05)));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"", "Product Owner",
                "Directs the course of development, discusses possibilities and limits with the client, evaluates the fulfillment...",
                LocalDate.of(2000,10,05), LocalDate.of(2001,10,05)));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"IBM", null,
                "Directs the course of development, discusses possibilities and limits with the client, evaluates the fulfillment...",
                LocalDate.of(2000,10,05), LocalDate.of(2001,10,05)));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"IBM", "",
                "Directs the course of development, discusses possibilities and limits with the client, evaluates the fulfillment...",
                LocalDate.of(2000,10,05), LocalDate.of(2001,10,05)));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"IBM", "Product Owner",
                null,
                LocalDate.of(2000,10,05), LocalDate.of(2001,10,05)));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"IBM", "Product Owner",
                "",
                LocalDate.of(2000,10,05), LocalDate.of(2001,10,05)));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"IBM", "Product Owner",
                "Directs the course of development, discusses possibilities and limits with the client, evaluates the fulfillment...",
                null, LocalDate.of(2001,10,05)));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"IBM", "Product Owner",
                "Directs the course of development, discusses possibilities and limits with the client, evaluates the fulfillment...",
                LocalDate.of(2000,10,05), null));

        assertThrows(IllegalArgumentException.class, () -> new br.com.cleandomain.entities.ProfessionalExperience(UUID.randomUUID().getMostSignificantBits(),"IBM", "Product Owner",
                "Directs the course of development, discusses possibilities and limits with the client, evaluates the fulfillment...",
                LocalDate.of(2000,10,05), LocalDate.of(1988,10,05)));
    }
}