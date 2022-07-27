package br.com.cleanweb.controllers;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV3;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;



class UserControllerTest {

    @Test
    void validateSchemaStatic() {
        when().get("/create/user").then().assertThat().body(matchesJsonSchemaInClasspath("json/user.json"));
    }

    @Test
    void index() {
    }

    @Test
    void createUser() {

    }

    @Test
    void createUserCurriculum() {
    }
}