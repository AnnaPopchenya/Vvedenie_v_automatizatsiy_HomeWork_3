package org.example;


import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetLocationTest extends AccuweatherAbstractTest {

    @Test
    void getLocationTest() {
        List<Location> result = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Minsk")
                .when()
                .get(getBaseUrl()+"locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(6, result.size());

    }
}