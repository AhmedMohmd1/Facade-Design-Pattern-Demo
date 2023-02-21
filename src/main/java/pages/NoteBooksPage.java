package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoteBooksPage extends BasePage{
    public NoteBooksPage(WebDriver driver) {
        super(driver);
    }
    private By appleMacBookItem = By.xpath("//div[@data-productid=\"4\"]//a[@title=\"Show details for Apple MacBook Pro 13-inch\"]");

    public BuyingAppleMacBookPro13inch clickOnAppleMacBookPro13Inch() {
        WaitUntilVisibleElement(appleMacBookItem);
        clickElement(appleMacBookItem);
        return new BuyingAppleMacBookPro13inch(driver);
    }
}
