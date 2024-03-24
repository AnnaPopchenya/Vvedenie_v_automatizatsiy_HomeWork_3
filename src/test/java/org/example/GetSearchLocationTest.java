package org.example;


import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import static io.restassured.RestAssured.given;

public class GetSearchLocationTest extends AccuweatherAbstractTest{
    @Test
    void testSearchLocation() {
        Location location = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/28580")
                .then()
                .statusCode(200)
                .extract()
                .body().as(Location.class);

        Assertions.assertEquals("Minsk", location.getLocalizedName());

    }
}
