package Pages;

import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    By placeOrderButton = By.xpath("//*[contains(text(),'Place Order')]");



    public void placeOrder() {
        DriverHelper.getInstance().findElement(placeOrderButton).click();
    }
}
