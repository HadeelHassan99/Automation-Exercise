package Pages;

import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    By loginPage = By.xpath("//a[contains(text(),'Signup / Login')]");
    By addToCartButton = By.xpath("//*[contains(text(),'Add to cart')]");
    By viewCart = By.xpath("//*[contains(text(),'View Cart')]");


    public void navigateToLogin() {
        DriverHelper.getInstance().findElement(loginPage).click();
    }

    public void selectProduct(String productName) {
        By dynamicProductLink = By.xpath("//*[contains(text(),'" + productName + "')]");
        DriverHelper.getInstance().findElement(dynamicProductLink).click();
    }

    public void addToCart() {
        DriverHelper.getInstance().findElement(addToCartButton).click();
    }
    public void navigateToTheCart() {
        DriverHelper.getInstance().findElement(viewCart).click();
    }
}


