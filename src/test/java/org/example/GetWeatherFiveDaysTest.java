package org.example;


import org.example.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetWeatherFiveDaysTest extends AccuweatherAbstractTest{

    @Test
    void test5Days() {
        Weather weather = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"forecasts/v1/daily/5day/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Weather.class);

        Assertions.assertEquals(5, weather.getDailyForecasts().size());
        Assertions.assertEquals("rain", weather.getHeadline().getCategory());
    }
}
