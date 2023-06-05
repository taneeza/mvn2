package com.mycompany.app;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import openweatherapi.GetWeatherData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.isA;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.nullValue;
import io.restassured.*;
import io.restassured.response.*;

public class GetWeatherDataTest {

    private static final Logger logger = LogManager.getLogger(GetWeatherDataTest.class);


    @Test
    public void getWeatherTest(){
        String actualValue =  GetWeatherData.getWeatherData();
        Assert.assertEquals("IT",actualValue);
        logger.info("Test Passed");
    }


    @Test
    public void exampleRestTest() {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";
        given()
                .contentType(ContentType.JSON)
                //.pathParam("id", "AskJsd8Sd")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .body("base", equalTo("stations"))
                .body("coord.lat", equalTo(44.34F))
                .body("main.temp", equalTo(284.04F))
                .body("coord.lon", equalTo(10.99F));

                logger.info("test passed");

    }
    @Test
    public void longitudeTest() {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";
        given()
                //.contentType(ContentType.JSON)
                //.pathParam("id", "AskJsd8Sd")
                .when()
                .get(url)
                .then()
                .body("coord.lon", equalTo(10.99F));

        logger.info("test passed");

    }

    @Test // getting everything header, cookie, body, status code
    public void getResponseAll() {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";

        given().
                when().
                get(url).
                then()
                .log()
                .all();
    }
    @Test // getting whole response body
    public void getResponseBody() {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";

        given().
                when().
                get(url).
                then()
                .log()
                .body();
    }

    @Test // getting whole response body
    public void getResponseHeader() {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";

        given().
                when().
                get(url).
                then()
                .log()
                .headers();

    }
    @Test // getting whole response body
    public void getResponseCookies() {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";

        given().
                when().
                get(url).
                then()
                .log()
                .cookies();
    }
    @Test  // geting the value type of the parameter

    public void getValueType() {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";

        given().
                when().
                get(url).
                then()
                .body("coord.lon", isA(Float.class))
                .body("main.sea_level",  isA(Integer.class))
                .body("name",   isA(String.class))
                .body("dt", isA(Integer.class));

        logger.info("test passed");
    }
    @Test // getting the status code
            public void testGetStatusCode() {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";
        Response response = given().
                when().
                get(url).
                then().
                extract().response();
        int statusCode= response.getStatusCode();
        String contentType= response.getContentType();
        float path= response.path("coord.lon");
        logger.info("status code is  " + statusCode);
        logger.info(( " content Type =" + contentType));
        logger.info(path );
    }

}
