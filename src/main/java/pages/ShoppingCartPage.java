package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    By productName = By.xpath("//td//a[text()='Apple MacBook Pro 13-inch']");
    By numOfItems = By.xpath("//form[@id=\"shopping-cart-form\"]//table[@class=\"cart\"]//following-sibling::tbody//tr");
    By termsCheckBox = By.id("termsofservice");
    By checkOutButton = By.id("checkout");

    public String assertProductName() {
        return driver.findElement(productName).getText();
    }

    public int assertNumberOfItems() {
        return driver.findElements(numOfItems).size();
    }

    public void clickTermsCheckBox() {
        WaitUntilVisibleElement(termsCheckBox);
        scrollTillVisible(termsCheckBox);
        clickElement(termsCheckBox);
    }

    public CheckOutPage clickCheckOutButton() {
        WaitTillVisibleAndClick(checkOutButton);
        return new CheckOutPage(driver);
    }
}
