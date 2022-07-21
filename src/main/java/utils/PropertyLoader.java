package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private PropertyLoader() {
    }

    public static String getPropertyValue(final String property) {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            properties.load(propFileInpStream);
            return properties.getProperty(property);
        } catch (IOException e) {
            throw new NoPropertiesException("Properties file not found.");
        }
    }
}
