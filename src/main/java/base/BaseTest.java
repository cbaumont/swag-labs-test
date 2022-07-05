package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.LocalChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static utils.PropertyLoader.getPropertyValue;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {

    private static WebDriver driver;
    protected static String username;
    protected static String password;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void preCondition() {
        DriverFactory localDriver = new LocalChromeDriver();
        driver = localDriver.getDriver();
        driver.get(getPropertyValue("url.base"));
        username = getPropertyValue("username");
        password = getPropertyValue("password");
    }

    @AfterMethod
    public void postCondition() {
        driver.quit();
    }
}