package MyAPITest;

import MyTest.MainPage;
import api.reqres.registration.Register;
import api.reqres.registration.SuccessUserReg;
import api.spec.Specifications;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APITest extends BaseSelenideTest {
    private static final String URL = "https://petstore.swagger.io/#/pet/addPet";

    @Test
    public void successUserRegTest(){
        api.spec.Specifications.installSpecification(api.spec.Specifications.requestSpec(URL), Specifications.responseSpecOK200());


















        Register user = new Register("eve.holt@reqres.in","pistol");
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
