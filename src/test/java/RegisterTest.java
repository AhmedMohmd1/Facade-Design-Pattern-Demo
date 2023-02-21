import base.BaseTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;


    @Test
    public void testRegister() {
        registerPage = homePage.clickRegisterIcon();
        registerPage.completeData("ahmed", "mohamed", "ahmed1998@gmail.com",
                "FacadeDesignPattern", "123456", "123456");
        registerPage.clickRegisterButton();

        soft.assertEquals(registerPage.isErrorMessagePresent(), "Your registration completed",
                "Your registration Process didn't complete ");
    }
}
