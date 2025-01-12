package Pages;

import Helpers.DriverHelper;
import org.openqa.selenium.By;

public class PaymentPage {

    By nameOnCardInput = By.name("name_on_card");
    By cardNumberInput = By.name("card_number");
    By CVCInput = By.name("cvc");
    By expirationMonthInput = By.name("expiry_month");
    By expirationYearInput = By.name("expiry_year");
    By confirmOrderButton = By.id("submit");
    By confirmationMessage = By.xpath("//h2[contains(text(),'Order Confirmed')]");

    public void enterPaymentDetails(String nameOnCard, String cardNumber, String CVC, String expirationMonth, String expirationYear ) {
        DriverHelper.getInstance().findElement(nameOnCardInput).sendKeys(nameOnCard);
        DriverHelper.getInstance().findElement(cardNumberInput).sendKeys(cardNumber);
        DriverHelper.getInstance().findElement(CVCInput).sendKeys(CVC);
        DriverHelper.getInstance().findElement(expirationMonthInput).sendKeys(expirationMonth);
        DriverHelper.getInstance().findElement(expirationYearInput).sendKeys(expirationYear);
        DriverHelper.getInstance().findElement(confirmOrderButton).click();
    }
}


