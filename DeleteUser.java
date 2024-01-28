package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class DeleteUser {
     @Test
    void test_deleteUser(ITestContext context) {
        String bearerToken = "b4c77734e7ef32a2afdb31e08248aa10da2db7079c0b759d12e854361cc3a909";
        //int id = (int) context.getAttribute("user_id");
         int id = (int) context.getSuite().getAttribute("user_id");
        given()
                      .headers("Authorization","Bearer " + bearerToken)
                      .pathParam("id",id)
                .when()
                      .delete("https://gorest.co.in/public/v2/users/{id}")

                .then()
                      .statusCode(204)
                      .log().all();

    }
}
