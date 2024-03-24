package org.example;


import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetCityNeighborsTest extends AccuweatherAbstractTest{

    @Test
    void testCityNeighbors() {
        List<Location> locationListList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/cities/neighbors/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Location location = locationListList.get(0); // Получаем первый элемент из списка

        Assertions.assertEquals("Fanipal", location.getLocalizedName());

    }
}