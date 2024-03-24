package org.example;


import org.example.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetTopFiftyCitiesTest extends AccuweatherAbstractTest {

    @Test
    void testTop50Cities() {
        List<Location> locationList = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl() + "locations/v1/topcities/50")
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Location location = locationList.get(0);
        Location location1 = locationList.get(4);

        Assertions.assertEquals("Dhaka", location.getLocalizedName());
        Assertions.assertEquals("Colombia", location1.getCountry().getLocalizedName());
    }
}
