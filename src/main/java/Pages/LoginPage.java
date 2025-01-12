package Pages;

import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HomePage {
    private By email = By.cssSelector("[type='email']");
    private By password = By.cssSelector("[type='password']");
    private By loginBttn = By.cssSelector("[type='submit']");


    public void login(String userEmail, String userPassword) {
        navigateToLogin();
        DriverHelper.getInstance().findElement(email).sendKeys(userEmail);
        DriverHelper.getInstance().findElement(password).sendKeys(userPassword);
        DriverHelper.getInstance().findElement(loginBttn).click();
    }
}
