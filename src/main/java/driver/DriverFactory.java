package driver;

public class DriverFactory {

    public LocalDriver create(String driverType) {
        if (driverType.equalsIgnoreCase("firefox")) {
            return new FirefoxLocalDriver();
        } else if (driverType.equalsIgnoreCase("chrome")) {
            return new ChromeLocalDriver();
        }
        return null;
    }
}
