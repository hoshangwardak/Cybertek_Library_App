package com.cybertek.utilities;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class API_Util {
    public static String getToken(String tokenUsername, String tokenPassword){

        return given()
                .contentType(ContentType.URLENC)
                .formParam("email", tokenUsername)
                .formParam("password" , tokenPassword).
                        when()
                .post("/login")
                .path("token");

    }
}
