package driver;

public class DriverFactory {

    public LocalDriver create(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxLocalDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeLocalDriver();
        }
        throw new BrowserNotSupportedException("The browser " + browser + " is not supported.");
    }
}
