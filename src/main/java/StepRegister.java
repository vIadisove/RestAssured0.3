import Model.RegisterRequestModel;

public class StepRegister {
    ApiRegister apiRegister = new ApiRegister();

    public void register(String email, String password){
        RegisterRequestModel model = new RegisterRequestModel(email, password);
        apiRegister.register(model);
    }
}
