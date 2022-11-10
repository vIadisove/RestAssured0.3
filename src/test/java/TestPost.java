import org.testng.annotations.Test;

public class TestPost {
    StepUser stepUser = new StepUser();
    @Test
    public void CreatePostTest(){
        stepUser.createUser("name","job");

    }

    StepRegister stepRegister = new StepRegister();
    @Test
    public void RegisterPostTest(){
        stepRegister.register("george.bluth@reqres.in", "pistol");
    }

}
