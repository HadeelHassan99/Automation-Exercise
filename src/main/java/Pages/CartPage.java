package Pages;

import Helpers.DriverHelper;
import org.openqa.selenium.By;

public class CartPage {
    By proceedToCheckoutButton = By.xpath("//*[contains(text(),'Proceed To Checkout')]");


    public void proceedToCheckout() {
        DriverHelper.getInstance().findElement(proceedToCheckoutButton).click();
    }
}

