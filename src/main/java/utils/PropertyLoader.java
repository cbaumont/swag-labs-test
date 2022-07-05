package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final Logger LOGGER = LogManager.getLogger();

    private PropertyLoader() {
    }

    public static String getPropertyValue(final String property) {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            properties.load(propFileInpStream);
            return properties.getProperty(property);
        } catch (IOException e) {
            LOGGER.error("Property not found!", e);
            throw new NoPropertiesException("No configuration file!");
        }
    }
}
