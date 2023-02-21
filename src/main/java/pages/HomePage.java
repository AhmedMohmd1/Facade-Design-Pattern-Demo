package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By registerIcon = By.xpath("//ul/li/a[@class='ico-register']");
    private By loginicon = By.xpath("//div//a[@class='ico-login']");
    private By logOutElement = By.xpath("//a[@href=\"/logout\"]");

    private By AnchorElementForProducts = By.xpath("//div[@class=\"product-grid home-page-product-grid\"]//div[@class=\"title\"]");
    private By currencyElement = By.xpath("//span[@class=\"price actual-price\"]");

    private By searchBoxField = By.xpath("//input[@id=\"small-searchterms\"]");
    private By searchButton = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    private By appleMacBookItem = By.xpath("//div[@data-productid=\"4\"]//a[@title=\"Show details for Apple MacBook Pro 13-inch\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickRegisterIcon() {
        WaitTillVisibleAndClick(registerIcon);
        return new RegisterPage(driver);
    }

    public LoginPage clickLoginIcon() {
        WaitTillVisibleAndClick(loginicon);
        return new LoginPage(driver);
    }

    public WebElement selectElement(String elementName) {
        WebElement menuElement = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li//a[@href=\"/" + elementName + "\"]"));
        return menuElement;
    }

    public NoteBooksPage selectNoteBooksMenu(String MenuElementName, String SubElementName) {
        actions.moveToElement(selectElement(MenuElementName)).perform();
        actions.moveToElement(selectElement(SubElementName)).click().perform();
        return new NoteBooksPage(driver);
    }
}