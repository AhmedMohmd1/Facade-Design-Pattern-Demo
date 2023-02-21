package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    By cityElement = By.id("BillingNewAddress_City");
    WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
    By selectElement = By.id("BillingNewAddress_CountryId");
    By address1 = By.id("BillingNewAddress_Address1");
    By postalCode = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By continueButtonBilling = By.xpath("//button[@onclick='Billing.save()']");
    WebElement editButtonBilling = driver.findElement(By.id("edit-billing-address-button"));
    By continueButtonShipping = By.xpath("//button[@onclick='ShippingMethod.save()']");
    By continueButtonPayment = By.xpath("//button[@onclick='PaymentMethod.save()']");
    By continueButtonPaymentInfo = By.xpath("//button[@onclick='PaymentInfo.save()']");
    By continueButtonConfirmOrder = By.xpath("//button[@onclick='ConfirmOrder.save()']");
    By successMessage = By.xpath("//strong[text()='Your order has been successfully processed!']");


    public String checkOut() {
        billingAddress();
        shippingAddress();
        paymentMethod();
        paymentInfo();
        confirmOrder();
        return assertSuccessMessage();
    }

    public void billingAddress() {
        if (editButtonBilling.isDisplayed()) {
            clickElement(continueButtonBilling);
        } else {
            wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(selectElement, By.tagName("value")));
            selectFromDropdownByValue(country, "123");
            WaitTillVisibleAndSendKeys(cityElement, "cairo");
            WaitTillVisibleAndSendKeys(address1, "cairo");
            waitTillElementBeClickable(postalCode);
            sendKeys(postalCode, "3753450");
            WaitTillVisibleAndSendKeys(phoneNumber, "1234567890");
            WaitTillVisibleAndClick(continueButtonBilling);
        }
    }

    public void shippingAddress() {
        WaitTillVisibleAndClick(continueButtonShipping);
    }

    public void paymentMethod() {
        WaitTillVisibleAndClick(continueButtonPayment);
    }

    public void paymentInfo() {
        WaitTillVisibleAndClick(continueButtonPaymentInfo);
    }

    public void confirmOrder() {
        scrollTillVisible(continueButtonConfirmOrder);
        WaitTillVisibleAndClick(continueButtonConfirmOrder);
    }

    public String assertSuccessMessage() {
        WaitUntilVisibleElement(successMessage);

        return getText(successMessage);
    }

}
