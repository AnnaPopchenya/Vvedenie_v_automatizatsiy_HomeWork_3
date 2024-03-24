package org.example;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetWeatherSeventyTwoHourTest extends AccuweatherAbstractTest{

    @Test
    void getSeventyTwoHour_shouldReturn401(){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"forecasts/v1/hourly/72hour/28580")
                .then()
                .statusCode(401);
    }
}
