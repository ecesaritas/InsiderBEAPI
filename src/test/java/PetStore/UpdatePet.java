package PetStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class UpdatePet {

    @Test
    public void updateCat(){
        String updateCat = "{\n" +
                "  \"id\": 2,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"cat\"\n" +
                "  },\n" +
                "  \"name\": \"Sef\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"cute\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"unavailable\"\n" +
                "}";

        RestAssured.given().body(updateCat).
                contentType(ContentType.JSON).
                log().all().
                when()
                .put("https://petstore.swagger.io/v2/pet").
                then().statusCode(200)
                .log().all();
    }
}
