package com.controllers;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class LabSeqControllerTest {
    @Test
    void testSuccessLabSeqEndpoint() {
        given()
                .when().get("/labseq/90")
                .then()
                .statusCode(200)
                .body(is("24815508"));
    }

    @Test
    void testFailureLabSeqEndpoint() {
        given()
                .when().get("/labseq/-90")
                .then()
                .statusCode(400)
                .body(is("The n parameter must be a positive integer."));
    }


}