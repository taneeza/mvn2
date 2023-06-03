package com.mycompany.app;
 /* Make  post call - use this tutorial https://devqa.io/rest-assured-api-requests-examples/#:~:text=To%20send%20a%20POST%20request%20in%20REST%2Dassured%2C%20we%20use%20the%20post()%20method%3A
  curl --location 'https://5x9m5ed0tj.execute-api.us-east-1.amazonaws.com/test/submit' \
--header 'Authorization: Bearer eyJraWQiOiJtNlhhM3FkczlxY2o2ODZYOVBRb0JqTEJSQU5yMzBPZ21ZQzdvdThZc1N3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxdTVpbzR2YTlzcjQ1bjc5ZmNlZzJkYW1qZiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiaXphYW5fdGVzdFwvcG9zdF9pbmZvIiwiYXV0aF90aW1lIjoxNjczNzIzMTI4LCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9ZN3k4cTVDMVoiLCJleHAiOjE2NzM3MjY3MjgsImlhdCI6MTY3MzcyMzEyOCwidmVyc2lvbiI6MiwianRpIjoiNzQ2NWYyMGItM2VlZS00ODgzLThjMTUtM2YyM2ZhYjI2MTc4IiwiY2xpZW50X2lkIjoiMXU1aW80dmE5c3I0NW43OWZjZWcyZGFtamYifQ.HX8ntkB6yh9EHNyWRIB-UuKkza9T-9w3GxseQtxGbkC7q1MD2sum-0IZGgRiLSiBZy8Ays2LTPuGZzqXueK4besAhA_WwIT1rWOP07LexDkI5YBuDQew3yI-gGavSPQIldPGE8jlm_vSs-8im298fXvgIdHD0I-BWGq1tDb-Lwoi0GEeyPjXRxWfrLaAPGnW_tNJNRkPYjJJ6uUvxFsw3DpEgUYnzaDz5ekM6hOWgdaCH_hA6inxyDFAJFwdUgL5VawGtTHzLvFaVYF40AefDMQLWkp1m0-2keFNseZFCBzlzBsdhGQca9Y7vI4ZbJE4CqB3v1aoAxSzT8hCFEe6cw' \
--header 'Content-Type: application/json' \
--data '{
  "name" : "John",
  "age" : 10
}' */
import io.restassured.response.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest {
    private static final Logger logger = LogManager.getLogger(GetTokenTest.class);
    @Test
    public void postRequest() {
         String requestBody = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": 50\n" +
                 "}";
        String url = "https://5x9m5ed0tj.execute-api.us-east-1.amazonaws.com/test/submit";
        Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer eyJraWQiOiJtNlhhM3FkczlxY2o2ODZYOVBRb0JqTEJSQU5yMzBPZ21ZQzdvdThZc1N3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxdTVpbzR2YTlzcjQ1bjc5ZmNlZzJkYW1qZiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiaXphYW5fdGVzdFwvcG9zdF9pbmZvIiwiYXV0aF90aW1lIjoxNjg1ODA0NTU5LCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9ZN3k4cTVDMVoiLCJleHAiOjE2ODU4MDgxNTksImlhdCI6MTY4NTgwNDU1OSwidmVyc2lvbiI6MiwianRpIjoiZTk4ZmQ1NTctNDVmNi00MzhjLWE5NmItMzUyNDljY2ZmYjRkIiwiY2xpZW50X2lkIjoiMXU1aW80dmE5c3I0NW43OWZjZWcyZGFtamYifQ.NLDlNJIQr29MHAKjt4exMcfzUkihWHL-hvvVlJbzcaVChM5cHWdhlkE4blwyl-0tjebnIVMpqoo9hHFLnKU2E-Ti_TABLJNXrjaf_m6z5ssI1tNsmL6-1NGjBrm85cZgiZgyKpHq7FAiGEwjY2e6fiRcW_uFx2Y7zMHJPQjn2P-VcwGVZN1rbxJoLp5zsi7JH1skK2SEvi3Srdt_3C1G8c7HbPmKBSEkd28598gOrV0io5xTo1hWndDE54qshVS7RT17kDu4vU0ujSJ0GXDC73uOYEb0MqYOjtHau4JYXDXJE0DrWFn11gMjG8jqeFdUtO_ecV561wo83jBBnf0avw")
                .and()
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .extract().response();
        String message = response.jsonPath().getString("message");
        logger.info(message);
        Assert.assertEquals(200, response.statusCode());
    }
}
//https://reqres.in/api/login
//https://reqres.in/api/users