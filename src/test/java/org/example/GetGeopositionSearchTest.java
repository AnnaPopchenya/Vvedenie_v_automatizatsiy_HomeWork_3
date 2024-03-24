package org.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetGeopositionSearchTest extends AccuweatherAbstractTest{
    @Test
    void getGeopositionSearch_shouldReturn400(){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"locations/v1/cities/geoposition/search")
                .then()
                .statusCode(400);
    }
}
