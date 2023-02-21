package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.yaml.snakeyaml.nodes.NodeId.anchor;

public class BuyingAppleMacBookPro13inch extends BasePage {


    public BuyingAppleMacBookPro13inch(WebDriver driver) {
        super(driver);
    }

    By shoppingElement = By.xpath("//span[text()='Shopping cart']//parent::a");
    By anchorElement = By.xpath("//div[@class=\"product-name\"]//h1");


    public void clickToAddToCartButton() {
        scrollTillVisible(anchorElement);
        clickAddToCartButtonMethod();
        clickCloseNotification();
    }

    public ShoppingCartPage clickOnShoppingCartIcon() {
        scrollToTopPage();
        WaitTillVisibleAndClick(shoppingElement);
        return new ShoppingCartPage(driver);
    }

}

