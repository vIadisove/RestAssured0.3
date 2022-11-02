package Model;

import lombok.Data;

@Data
public class RegisterRequestModel {
    private String email;
    private String password;

    public RegisterRequestModel(String email, String password){
        this.email = email;
        this.password = password;
    }
}
