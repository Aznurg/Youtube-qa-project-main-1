package MyAPITest;

import api.spec.Specifications;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APITest {
    int flopaId = 0;
    private static final String URL = "https://petstore.swagger.io/v2";

    @Test
    @Order(1)
    public void putPetTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Root pet = new Root(322, new Category(323, "animal"), "Flopa", new ArrayList<String>(), new ArrayList<Tag>(), "available");
        Response addPet = given()
                .body(pet)
                .when()
                .post("/pet")
                .then().log().all()
                .extract().response();
        System.out.println("Создан " + pet.getName() + " с ID " + pet.getId());
    }

    @Test
    @Order(2)
    public void findPetTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Response findPet = given()
                .when()
                .get("/pet/findByStatus?status=available")
                .then().log().all()
                .body("name", notNullValue())
                .body("id", notNullValue())
                .extract().response();
        JsonPath availablePets = findPet.jsonPath();
        List<String> names = availablePets.get("name");
        List<Integer> ids = availablePets.get("id");
        for (int i = 0; i < names.size()-1; i++) {

            /*if(names.get(i)==null){
                System.out.println("FOUND NULL WITH INDEX "+ i);
            }
*/
            if (names.get(i)!=null&&names.get(i).equals("Flopa")) {
                System.out.println("Найден " + names.get(i) + " с ID " + ids.get(i));
                flopaId = ids.get(i);
            }
        }
    }
    @Test
    @Order(3)
    public void deletePetTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError404());
        String target = "/pet/" + flopaId;
        Response deletePet = given()
                .when()
                .delete("target")
                .then().log().all()
                .extract().response();
        System.out.println("Мир праху вашего питомца");
    }
    @Test
    @Order(4)
    public void checkIfPetDeleted() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError404());
        Response findPet = given()
                .when()
                .get("/pet/"+flopaId)
                .then().log().all()
                .extract().response();
        Assertions.assertEquals("Pet not found",findPet.jsonPath().get("message"));

        System.out.println("И следа его не осталось в этом мире");

    }
}