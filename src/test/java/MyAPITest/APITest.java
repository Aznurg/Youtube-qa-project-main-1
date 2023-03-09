package MyAPITest;

import api.spec.Specifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APITest{
    private static final String URL = "https://petstore.swagger.io/v2";

    @Test
    public void putPetTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Root pet = new Root(322,new Category(323, "animal"), "Slopa", new ArrayList<String>(), new ArrayList<Tag>(), "available");
        Response addPet = given()
                .body(pet)
                .when()
                .post("/pet")
                .then().log().all()
                .extract().response();
    }
    @Test
    public void findPetTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        String expectedStatus = "available";
        Response findPet = given()
                .body(expectedStatus)
                .when()
                .get("/pet/findByStatus")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = findPet.jsonPath();
        ArrayList result = jsonPath.get("name");
    }
}
