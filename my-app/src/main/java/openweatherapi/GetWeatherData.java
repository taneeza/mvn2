package openweatherapi;

import io.restassured.*;
import io.restassured.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetWeatherData {

    private static final Logger logger = LogManager.getLogger(GetWeatherData.class);

    public static String getWeatherData(){
        /**
         * 1. Is to prepare for the call - HostName, Port Number if there is any
         *  resource name, query parameter
         * 2. Execute Call and get the response. And hold the response in a response object/container
         * 3. Validate the response as much as possible based on the requirements and manual test case
         *
         * */

        // Step 1
        String endpointUrl = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=b0d80a82ca4a159fffb4e272a0833b5a";

        // Step 2
        Response response = RestAssured.get(endpointUrl);

        // Step 3 - response --> Headers, Cookies, Status, Response Body

        String responseBody = response.getBody().asString();
        int statusCode= response.getStatusCode();

        logger.info("Response Body " + responseBody);
        logger.info("status code" + statusCode);

        String base = response.path("base");
        String coord = response.path("coord.lon").toString();
        String country= response.path( "sys.country");
       // String country2= response.path( "weather");

        //JsonPathConfig jsonPathConfig = response.;

        // How to get coord value and base value????
        // response.getBody().jsonPath("coord");
        logger.info(base);
        logger.info(coord);
        logger.info(country);
       // logger.info(country2);
        return country;

    }
}