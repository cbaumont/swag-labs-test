package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.CustomerData;

import static utils.PropertyLoader.getPropertyValue;

@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
public abstract class BaseTest {

    private static WebDriver driver;
    protected String username;
    protected String password;
    protected CustomerData customerData;

    public static synchronized WebDriver getDriver() {
        return driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void preCondition(@Optional("chrome") String browser) {
        driver = new DriverFactory().create(browser).getDriver();
        driver.get(getPropertyValue("url.base"));
        username = getPropertyValue("username");
        password = getPropertyValue("password");
        customerData = new CustomerData();
    }

    @AfterClass
    public void postCondition() {
        driver.quit();
    }
}