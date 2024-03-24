package org.example;


import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetIPAddressSearchTest extends AccuweatherAbstractTest{
    @Test
    void testIPAddressSearch() {
        Location location = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/cities/ipaddress")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Location.class);

        Assertions.assertEquals("Brest", location.getLocalizedName());

    }
}

