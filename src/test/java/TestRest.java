import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.CreateUserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojo;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class TestRest {
    @Test
    public void GetUsers(){
               List <UserPojo> users = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .when().get("/api/users")
                .then().statusCode(200)
                       .extract().jsonPath().getList("data", UserPojo.class);

               assertThat(users).extracting(UserPojo::getEmail).contains("george.bluth@reqres.in");


    }

    @Test
    public void CreateUser(){
        CreateUserRequest rq = new CreateUserRequest();
        rq.setName("Babulex");
        rq.setJob("Babijon");

        CreateUserResponse rs = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post("/api/users")
                .then().statusCode(201).extract().as(CreateUserResponse.class);

//        assertThat(rs)
//                .isNotNull()
//                .extracting(CreateUserResponse::getName)
//                .isEqualTo(rq.getName());



    }

}
