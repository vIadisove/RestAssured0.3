import Model.RegisterRequestModel;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ApiRegister {
    public void register(RegisterRequestModel model){
        given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .body(model)
                .post("api/register")
                .then()
                .statusCode(200)
                .log().all();

    }
}
