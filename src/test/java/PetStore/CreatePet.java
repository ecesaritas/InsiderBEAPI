package PetStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.given;

public class CreatePet {

    @Test
    public void createPet() {

        String createCat = "{\n" +
                "  \"id\": 1,\n" +
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
                "  \"status\": \"available\"\n" +
                "}";

            RestAssured.given().
                    body(createCat).
                    contentType(ContentType.JSON).
                    log().all().
                    when()
                    .post("https://petstore.swagger.io/v2/pet").
                    then().statusCode(200)
                    .log().all();

    }


}