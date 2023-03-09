package MyAPITest;

import api.spec.Specifications;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APITest{
    private static final String URL = "https://petstore.swagger.io";

    @Test
    public void putPetTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Root root = new Root();
        Tag tag = new Tag(324, "cat");
        Root pet = new Root(322,new Category(323, "animal"), "Slopa", new ArrayList<String>(), new ArrayList<Tag>(), "chilling");
        Response response = given()
                .body(pet)
                .when()
                .post("/v2/pet")
                .then().log().all()
                .extract().response();







//        Map<String, String> pet = new HashMap<>();
//        pet.put("name", "Slopa");
//        pet.put("id", "322");
//        Response response = given()
//                .body(pet)
//                .when()
//                .post("pet")
//                .then().log().all()
//                .extract().response();
//        JsonPath jsonPath = response.jsonPath();
//        String petName = jsonPath.get("name");
//        Assertions.assertEquals("Slopa",petName);


//        Register user = new Register("eve.holt@reqres.in","pistol");
//        SuccessUserReg successUserReg = given()
//                .body(user)
//                .when()
//                .post("api/register")
//                .then()
//                .log().all()
//                .extract().as(SuccessUserReg.class);
//        Assertions.assertNotNull(successUserReg.getId());
//        Assertions.assertNotNull(successUserReg.getToken());
//        Assertions.assertEquals(UserId, successUserReg.getId());
//        Assertions.assertEquals(UserPassword, successUserReg.getToken());
    }
}
