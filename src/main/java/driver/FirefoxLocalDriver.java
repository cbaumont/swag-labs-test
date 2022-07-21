package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxLocalDriver implements LocalDriver {

    FirefoxOptions firefoxOptions;

    public FirefoxLocalDriver() {
        firefoxOptions = BrowserOptions.getFirefoxOptions();
    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }
}
