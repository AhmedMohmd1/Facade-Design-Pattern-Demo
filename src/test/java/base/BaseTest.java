package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.PlaceOrderFacade;

public class BaseTest {

    public static final String BASE_URL = "https://demo.nopcommerce.com/";
    protected WebDriver driver;
    protected HomePage homePage;
    protected SoftAssert soft;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        homePage = new HomePage(driver);
        soft = new SoftAssert();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
