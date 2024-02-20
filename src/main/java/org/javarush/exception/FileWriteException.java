package org.javarush.exception;

public class FileWriteException extends RuntimeException {
    public FileWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWriteException(String message) {
        super(message);
    }
}
