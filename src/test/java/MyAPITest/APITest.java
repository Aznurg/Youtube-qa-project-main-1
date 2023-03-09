package MyAPITest;

import api.spec.Specifications;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest{
    private static final String URL = "https://petstore.swagger.io/v2";

    @Test
    public void putPetTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Root pet = new Root(322,new Category(323, "animal"), "Flopa", new ArrayList<String>(), new ArrayList<Tag>(), "available");
        Response addPet = given()
                .body(pet)
                .when()
                .post("/pet")
                .then().log().all()
                .extract().response();
        System.out.println("Создан "+pet.getName()+" с ID "+pet.getId());
    }
    @Test
    public void findPetTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Response findPet = given()
                .when()
                .get("/pet/findByStatus?status=available")
//                .then().log().all()
//                .extract().body().jsonPath().get();
//        List<String> names = findPet.get("data.name");
                .then()
                .body("name", notNullValue())
                .body("id", notNullValue())
                .extract().response();
            JsonPath availablePets = findPet.jsonPath();
        List<String> names = availablePets.get("name");
        List<Integer> ids = availablePets.get("id");
        for(int i = 0; i<names.size(); i++){
            if (names.get(i).equals("Flopa")){
                System.out.println("Найден "+names.get(i)+" с ID "+ids.get(i));
            }
        }
    }
}
