package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalChromeDriver implements DriverFactory {

    ChromeOptions chromeOptions;

    public LocalChromeDriver() {
        chromeOptions = BrowserOptions.getChromeOptions();
    }

    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}
