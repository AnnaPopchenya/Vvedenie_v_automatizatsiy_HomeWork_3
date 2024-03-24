package org.example;


import org.example.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetWeatherTwelveHourTest extends AccuweatherAbstractTest{

    @Test
    void test12Hour() {
        List<Weather> weatherList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "forecasts/v1/hourly/12hour/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Weather.class);

        Weather weather = weatherList.get(0); // Получаем первый элемент из списка

        Assertions.assertEquals("Rain", weather.getPrecipitationType());

    }
}