package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {
    private static DriverHelper driverHelper;
    private final WebDriver driver;


    private DriverHelper() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getInstance() {
        if(driverHelper == null) {
            driverHelper = new DriverHelper();
        }
        return driverHelper.driver;
    }
}
