package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    protected By close = By.xpath("//div[@id=\"bar-notification\"]//child::span");
    protected By addToCartIcon = By.xpath("//button[@id=\"add-to-cart-button-4\"]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.actions = new Actions(driver);
    }

    public void clickCloseNotification() {
        WaitUntilVisibleElement(close);
        clickElement(close);
    }

    public WebElement clickElement(By element) {
        WebElement clickableElement = driver.findElement(element);
        clickableElement.click();
        return clickableElement;
    }

    public void WaitUntilVisibleElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void scrollTillVisible(By element) {
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void scrollToTopPage() {
        ((JavascriptExecutor) driver).
                executeScript("window.scrollTo(0, 0)");
    }

    public void WaitAndScrollTillVisible(By element) {
        WaitUntilVisibleElement(element);
        scrollTillVisible(element);
    }

    public void clickAddToCartButtonMethod() {
        WaitUntilVisibleElement(addToCartIcon);
        clickElement(addToCartIcon);
    }

    public void selectFromDropdownByValue(WebElement element, String value) {

        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public void WaitTillPresenceOfNestedElement(By element) {
        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(element, By.id("value")));
    }

    public void waitTillElementBeClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void WaitTillVisibleAndSendKeys(By element, String keyword) {
        WaitUntilVisibleElement(element);
        driver.findElement(element).sendKeys(keyword);
    }

    public void WaitTillVisibleAndClick(By element) {
        WaitUntilVisibleElement(element);
        clickElement(element);
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public void sendKeys(By element, String text) {
        driver.findElement(element).sendKeys(Keys.ENTER, text);
    }
}
