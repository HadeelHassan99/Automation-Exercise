package Pages;

import Helpers.DriverHelper;
import org.openqa.selenium.By;

public class ConfirmationPage {
    static By confirmationMessage = By.xpath("//*[contains(text(),'Congratulations! Your order has been confirmed!')]");

    public static boolean isOrderConfirmed() {
        return DriverHelper.getInstance().findElement(confirmationMessage).isDisplayed();
    }
}
