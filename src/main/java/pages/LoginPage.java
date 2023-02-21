package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By emailFiled = By.xpath("(//input[@id='Email'])[1]");
    private By passwordField = By.xpath("//div[@class='inputs']//input[@id='Password']");
    private By loginButton = By.xpath("(//div[@class='buttons']//button[@class='button-1 login-button'])");
    private By logOutElement = By.xpath("//a[@href=\"/logout\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterAccountData(String mail, String password) {
        driver.findElement(emailFiled).sendKeys(mail);
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
        passwordElement.sendKeys(Keys.ENTER);
    }

    public boolean isDisabled() {
        return driver.findElement(logOutElement).isDisplayed();
    }

}