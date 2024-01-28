package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class GetUser {
   @Test
    void test_getUser(ITestContext context){

       // int id = (int) context.getAttribute("user_id");
       int id = (int) context.getSuite().getAttribute("user_id");

        String bearerToken = "b4c77734e7ef32a2afdb31e08248aa10da2db7079c0b759d12e854361cc3a909";
        given()
                .headers("Authorization","Bearer "+bearerToken)
                .pathParam("id", id)

                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
