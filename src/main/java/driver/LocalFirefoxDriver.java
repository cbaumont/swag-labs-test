package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalFirefoxDriver implements DriverFactory {

    FirefoxOptions firefoxOptions;

    public LocalFirefoxDriver() {
        firefoxOptions = BrowserOptions.getFirefoxOptions();
    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }
}
