package PetStore;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test
public class DeletePet {

    public void deleteCat() {
        int petId= 5;
        given().log().all().
                header("api-key", "special-key").
                when().
                delete("https://petstore.swagger.io/v2/pet/" + petId).
                then()
                .statusCode(200).
                log().all();
    }

    public void deleteCatErrorCase() {
        int petId = 1;
        given().log().all().
                header("api-key", "special-key").
                when().
                delete("https://petstore.swagger.io/v2/pet/" + petId).
                then()
                .statusCode(404).
                log().all();
    }
}
