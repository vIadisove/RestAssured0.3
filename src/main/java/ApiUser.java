import Model.UserRequestModel;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


public class ApiUser {
    public void createUser(UserRequestModel model){
        given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .body(model)
                .post("api/users")
                .then()
                .statusCode(201)
                .log().all();

    }



}
