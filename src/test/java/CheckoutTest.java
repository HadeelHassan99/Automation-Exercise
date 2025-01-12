import Helpers.DriverHelper;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.JSONArray;
import org.json.JSONObject;

public class CheckoutTest extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;


    @BeforeMethod
    public void login() {
        DriverHelper.getInstance().get("https://automationexercise.com/");
        loginPage.login("daxove3629@wirelay.com", "123456789");
    }
    @BeforeClass
    public void initPage() {
        homePage = new HomePage();
        loginPage= new LoginPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
    }

    @Test(dataProvider = "checkoutData")
    public void testCheckout(String productName, String nameOnCard, String cardNumber, String CVC, String expirationMonth, String expirationYear) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) DriverHelper.getInstance();
        js.executeScript("window.scrollBy(0,500)");
        //Thread.sleep(2000);

        // Select product and add to cart
        homePage.selectProduct(productName);
        homePage.addToCart();

        //Go to the cart
        //Wait for the modal to be visible (WebDriverWait for the modal element)
        wait = new WebDriverWait(DriverHelper.getInstance(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'View Cart')]")));
        homePage.navigateToTheCart();

        // Proceed to checkout
        cartPage.proceedToCheckout();

        // Enter shipping/billing details
        js.executeScript("window.scrollBy(0,500)");
        checkoutPage.placeOrder();
        paymentPage.enterPaymentDetails(nameOnCard, cardNumber, CVC, expirationMonth, expirationYear);


        // Verify order confirmation
        Assert.assertTrue(ConfirmationPage.isOrderConfirmed(), "Congratulations! Your order has been confirmed! ");
    }

    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/checkoutData.jason"));
        StringBuilder json = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        reader.close();

        JSONArray testData = new JSONArray(json.toString());
        Object[][] data = new Object[testData.length()][6];

        for (int i = 0; i < testData.length(); i++) {
            JSONObject item = testData.getJSONObject(i);
            data[i][0] = item.getString("productName");
            data[i][1] = item.getString("nameOnCard");
            data[i][2] = item.getString("cardNumber");
            data[i][3] = item.getString("CVC");
            data[i][4] = item.getString("expirationMonth");
            data[i][5] = item.getString("expirationYear");
        }
        return data;
    }
}
