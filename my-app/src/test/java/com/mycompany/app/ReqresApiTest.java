package com.mycompany.app;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class ReqresApiTest {
    public static final Logger logger= LogManager.getLogger(ReqresApiTest.class);
@Rule public TestName testName= new TestName();

    @Test
// getting the whole response
    public void getAllTest(){
        String url= "https://reqres.in/api/users";
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .log()
                .all();
        String testMethodName= testName.getMethodName();
        logger.info(testMethodName + " test Passed");
    }

    @Test
    public void getBodyTest(){
        String url= "https://reqres.in/api/users";
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .log()
                .body();
    }

    @Test
    public void getHeader() {

        String url = "https://reqres.in/api/users";

        given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .log()
                .headers();
       logger.info(testName.getMethodName() + "successful");
    }

    @Test
    public void bodyParameterTest() {
        String url = "https://reqres.in/api/users";
        given()
                //.contentType(ContentType.JSON)
                //.pathParam("id", "AskJsd8Sd")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .body("total_pages", equalTo(2))
                .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        logger.info("test passed");

    }
    @Test
    public void getResponseValueTest(){
        String url= "https://reqres.in/api/users";
        Response response = given().
                when().
                get(url).
                then().
                extract().response();
        int statusCode= response.getStatusCode();
        String contentType= response.getContentType();
        int path= response.path("total");
        logger.info("status code is  " + statusCode);
        logger.info(( " content Type =" + contentType));
        logger.info(path );
    }

}
