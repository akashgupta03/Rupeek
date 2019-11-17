package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class ResourceHelper {

    public static Response get(String token, String url) {
        return given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .get(url);
    }

    public static Response post(String token, String url, String Json) {
        return given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .body(Json)
                .post(url);
    }


}
