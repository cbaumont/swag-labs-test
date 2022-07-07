package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;

public class BrowserOptions {

    private BrowserOptions() {
    }

    static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("lang=en");
        chromeOptions.setCapability("chrome.switches",
                Arrays.asList("--ignore-certificate-errors,--web-security=false,--ssl-protocol=any,--ignore-ssl-errors=true"));
        chromeOptions.setAcceptInsecureCerts(true);
        return chromeOptions;
    }

    static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.ERROR);
        firefoxOptions.setAcceptInsecureCerts(true);
        return firefoxOptions;
    }
}
