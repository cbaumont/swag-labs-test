package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.LocalChromeDriver;
import driver.LocalFirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static utils.PropertyLoader.getPropertyValue;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {

    private static WebDriver driver;
    protected static String username;
    protected static String password;

    public static WebDriver getDriver() {
        return driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void preCondition(@Optional("chrome") String browser) {
        DriverFactory localDriver;
        if (browser.equalsIgnoreCase("firefox")) {
            localDriver = new LocalFirefoxDriver();
        } else localDriver = new LocalChromeDriver();
        driver = localDriver.getDriver();
        driver.get(getPropertyValue("url.base"));

        username = getPropertyValue("username");
        password = getPropertyValue("password");
    }

    @AfterClass
    public void postCondition() {
        driver.quit();
    }
}