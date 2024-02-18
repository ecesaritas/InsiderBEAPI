package PetStore;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetPet {

    @Test
    public void getPet() {
        int petId = 10;
        given().log().all().
                when().
                get("https://petstore.swagger.io/v2/pet/" + petId).
                then()
                .statusCode(200)
                .body("name", startsWith("dog"))
                .body("category.id", equalTo(10))
                .body("tags[0].id", equalToObject(10)).log().all();
    }

    @Test
    public void getPetErrorCase() {
        int petId = 7;
        given().log().all().
                when().
                get("https://petstore.swagger.io/v2/pet/" + petId).
                then()
                .statusCode(404)
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("Pet not found")).log().all();
    }
}
