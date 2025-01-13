import Helpers.DriverHelper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUpDriver() {
        DriverHelper.getInstance();
    }

   @AfterSuite
    public void destroyDriver() {
        DriverHelper.getInstance().quit();
    }
}
