package org.example;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetWeatherTenDaysTest extends AccuweatherAbstractTest {

    @Test
    void getTenDays_shouldReturn401(){
        given()
                .queryParam("apikey", getApiKey())
                .pathParam("version", "v1")
                .pathParam("location", 28580)
                .when()
                .get(getBaseUrl()+"forecasts/{version}/daily/10day/{location}")
                .then()
                .statusCode(401);
    }
}