import base.BaseTest;
import org.testng.annotations.Test;
import pages.PlaceOrderFacade;

public class PlaceOrderFacadeTest extends BaseTest {
    private PlaceOrderFacade placeOrderFacade;

    @Test
    public void placeOrder() {
        placeOrderFacade = new PlaceOrderFacade(driver);
        String SuccessMessage = placeOrderFacade.placeOrder("ahmed", "mohamed", "ahmedmohamed36@gmail.com",
                "FacadeDesignPattern", "123456", "123456");
    
        soft.assertEquals(SuccessMessage, "Your order has been successfully processed!");
    }
}
