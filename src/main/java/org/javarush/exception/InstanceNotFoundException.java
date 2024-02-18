package org.javarush.exception;

public class InstanceNotFoundException extends RuntimeException {
    public InstanceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstanceNotFoundException(String message) {
        super(message);
    }
}
