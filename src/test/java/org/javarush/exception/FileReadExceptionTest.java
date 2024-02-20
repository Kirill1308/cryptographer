package org.javarush.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReadExceptionTest {

    @Test
    void fileReadException_message() {
        String errorMessage = "Test error message";

        FileReadException exception = new FileReadException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testFileReadException_messageAndCause() {
        String errorMessage = "Test error message";
        Throwable cause = new Throwable();

        FileReadException exception = new FileReadException(errorMessage, cause);

        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
