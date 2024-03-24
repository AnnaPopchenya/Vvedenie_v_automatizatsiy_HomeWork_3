package org.example;


import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRegionTest extends AccuweatherAbstractTest{
    @Test
    void testRegion() {
        List<Location> locationListList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/regions")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Location location = locationListList.get(0); // Получаем первый элемент из списка

        Assertions.assertEquals("Africa", location.getLocalizedName());

    }
}
