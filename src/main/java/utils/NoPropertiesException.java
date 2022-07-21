package utils;

public class NoPropertiesException extends RuntimeException {

    public NoPropertiesException(String message) {
        super(message);
    }

    public NoPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }
}
