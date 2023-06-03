package com.mycompany.app;

import io.restassured.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTokenTest {
    private static final Logger logger = LogManager.getLogger(GetTokenTest.class);
    @Test
    public void postRequest() {
        String url = "https://izaan-test.auth.us-east-1.amazoncognito.com/oauth2/token";
        Response response = given()
                .header("Content-type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic MXU1aW80dmE5c3I0NW43OWZjZWcyZGFtamY6MXFia3RodnA3bGJjN2FhdnVoaG1mZzhmMmNyZWtvcjloMmg3YWJ1Mm9ydTFubHBqNzFmZQ==")
                .and()
                .formParam("scope", "izaan_test/post_info")
                .formParam("grant_type", "client_credentials")
                .when()
                .post(url)
                .then()
                .extract().response();
        String token = response.jsonPath().getString("access_token");
        logger.info(token);
        Assert.assertEquals(200, response.statusCode());
    }

}