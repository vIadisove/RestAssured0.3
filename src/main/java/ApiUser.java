import Model.UserRequestModel;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiUser {
    public void createUser(UserRequestModel model){

        UserResponseModel up = given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .body(model)
                .post("api/users")
                .then()
                .statusCode(201)
                .log().all()
                .extract().as(UserResponseModel.class);

        assertThat(up)
                .isNotNull()
                .extracting(UserResponseModel::getName)
                .isEqualTo("name");
        assertThat(up)
                .extracting(UserResponseModel::getJob)
                .isEqualTo("job");




    }



}
