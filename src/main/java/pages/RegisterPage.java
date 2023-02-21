package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private By genderButton = By.xpath("(//div[@id='gender'])//input[@id='gender-male']");
    private By fName = By.xpath("(//div[@class='inputs'])[2]//input[@id='FirstName']");
    private By lName = By.xpath("(//div[@class='inputs'])[3]//input[@id='LastName']");
    private By email = By.xpath("(//div[@class='inputs'])//input[@id='Email']");
    private By company_Name = By.xpath("//div[@class='fieldset'][2]//input[@id='Company']");
    private By checkBox = By.xpath("//div[@class='form-fields']//input[@id='Newsletter']");
    private By Password = By.xpath("//div[@class='form-fields']//input[@id='Password']");
    private By confirm_Password = By.xpath("//div[@class='form-fields']//input[@id='ConfirmPassword']");
    private By register_Button = By.xpath("//div[@class='buttons']//button[@id='register-button']");
    private By ErrorMessage = By.xpath("//div[@class='message-error validation-summary-errors']//li");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void completeData(String FName, String SName,
                             String EMail, String com_name, String pass1, String confPass) {
        gender_btn();
        first_name(FName);
        second_name(SName);
        dropdown_date();
        Enter_Email(EMail);
        enterCompanyName(com_name);
        press_Check_Box();
        enterPassword(pass1, confPass);
    }

    public void gender_btn() {
        driver.findElement(genderButton).click();
    }

    public void first_name(String FName) {
        driver.findElement(fName).sendKeys(FName);
    }

    public void second_name(String SName) {
        driver.findElement(lName).sendKeys(SName);
    }

    public WebElement get_Day_of_Birth() {
        return driver.findElement(By.xpath("(//div[@class='inputs date-of-birth'])//select[@name='DateOfBirthDay']"));
    }

    public WebElement get_Month_of_Birth() {
        return driver.findElement(By.xpath("(//div[@class='inputs date-of-birth'])//select[@name='DateOfBirthMonth']"));
    }

    public WebElement get_Year_of_Birth() {
        return driver.findElement(By.xpath("(//div[@class='inputs date-of-birth'])//select[@name='DateOfBirthYear']"));
    }

    public void dropdown_date() {
        selectFromDropdownByValue(get_Day_of_Birth(), "11");
        selectFromDropdownByValue(get_Month_of_Birth(), "2");
        selectFromDropdownByValue(get_Year_of_Birth(), "2000");

//        Select day = new Select(get_Day_of_Birth());
//        Select month = new Select(get_Month_of_Birth());
//        Select year = new Select(get_Year_of_Birth());
//
//        day.selectByValue("11");
//        month.selectByValue("2");
//        year.selectByValue("2000");
    }

    public void Enter_Email(String EMail) {
        driver.findElement(email).sendKeys(EMail);
    }

    public void enterCompanyName(String com_name) {
        driver.findElement(company_Name).sendKeys(com_name);
    }

    public void press_Check_Box() {
        clickElement(checkBox);
    }

    public void enterPassword(String pass1, String confPass) {
        WaitTillVisibleAndSendKeys(Password, pass1);
        WaitTillVisibleAndSendKeys(confirm_Password, confPass);

    }

    public void clickRegisterButton() {
        WaitTillVisibleAndClick(register_Button);
    }

    public String isErrorMessagePresent() {
        WaitUntilVisibleElement(ErrorMessage);
        return getText(ErrorMessage);

    }

}
