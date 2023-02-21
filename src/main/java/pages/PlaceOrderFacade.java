package pages;

import org.openqa.selenium.WebDriver;

public class PlaceOrderFacade extends BasePage {
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    NoteBooksPage noteBooksPage;
    BuyingAppleMacBookPro13inch buy;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;


    public PlaceOrderFacade(WebDriver driver) {
        super(driver);
    }

    public String placeOrder(String FName, String SName,
                           String EMail, String com_name, String pass1, String confPass) {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        noteBooksPage = new NoteBooksPage(driver);
        buy = new BuyingAppleMacBookPro13inch(driver);
        shoppingCartPage = new ShoppingCartPage(driver);


        homePage.clickRegisterIcon();
        registerPage.completeData(FName, SName,
                EMail, com_name, pass1, confPass);
        registerPage.clickRegisterButton();
        homePage.clickLoginIcon();
        loginPage.enterAccountData(EMail, pass1);
        noteBooksPage = homePage.selectNoteBooksMenu("computers", "notebooks");
        noteBooksPage.clickOnAppleMacBookPro13Inch();
        buy.clickToAddToCartButton();
        shoppingCartPage = buy.clickOnShoppingCartIcon();
        shoppingCartPage.clickTermsCheckBox();
        checkOutPage = shoppingCartPage.clickCheckOutButton();
        return checkOutPage.checkOut();
    }
}
