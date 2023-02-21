import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginTest() {
        loginPage = homePage.clickLoginIcon();
        loginPage.enterAccountData("ahmedmohamed36@gmail.com", "123456");
        soft.assertTrue(loginPage.isDisabled());

    }

}
