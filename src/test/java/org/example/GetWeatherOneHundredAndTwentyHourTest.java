package org.example;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetWeatherOneHundredAndTwentyHourTest extends AccuweatherAbstractTest{

    @Test
    void getOneHundredAndTwentyHour_shouldReturn401(){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"forecasts/v1/hourly/120hour/28580")
                .then()
                .statusCode(401);
    }
}
