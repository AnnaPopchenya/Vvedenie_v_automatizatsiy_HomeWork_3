package org.example;


import org.example.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetWeatherOneHourTest extends AccuweatherAbstractTest{
    @Test
    void test1Hour() {
        List<Weather> weatherList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "forecasts/v1/hourly/1hour/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Weather.class);

        Weather weather = weatherList.get(0); // Получаем первый элемент из списка

        //тест упадёт, т.к. weather.getPrecipitationType == null, PrecipitationType не приходит в ответе
        Assertions.assertEquals("Rain", weather.getPrecipitationType());

    }
}
