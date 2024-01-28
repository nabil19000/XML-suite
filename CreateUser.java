package day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Test
    void test_CreateUser(ITestContext context){
        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name",faker.name().fullName());
        data.put("gender","Male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");
        String bearerToken = "b4c77734e7ef32a2afdb31e08248aa10da2db7079c0b759d12e854361cc3a909";

       int id =  given()
                      .headers("Authorization","Bearer "+bearerToken)
                      .contentType("application/json")
                      .body(data.toString())
                 .when()
                       .post("https://gorest.co.in/public/v2/users")
                       .jsonPath().getInt("id");

             System.out.println("Generated id is :"+id);
         // context.setAttribute("user_id",id);
        context.getSuite().setAttribute("user_id", id);
    }
}
