package day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {
@Test
    void test_updateUser(ITestContext context) {
    Faker faker = new Faker();
    JSONObject data = new JSONObject();
    data.put("name",faker.name().fullName());
    data.put("gender","Female");
    data.put("email",faker.internet().emailAddress());
    data.put("status","active");
    String bearerToken = "b4c77734e7ef32a2afdb31e08248aa10da2db7079c0b759d12e854361cc3a909";
      //  int id = (int) context.getAttribute("user_id");
    int id = (int) context.getSuite().getAttribute("user_id");

     given()
            .headers("Authorization","Bearer "+bearerToken)
            .contentType("application/json")
            .pathParam("id",id)
            .body(data.toString())
            .when()
            .put("https://gorest.co.in/public/v2/users/{id}")
                    .then()
                            .statusCode(200)
                                    .log().all();


    System.out.println("Generated id is :"+id);




}
    }

