package org.javarush.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class FileWriteExceptionTest {
    @Test
    void fileWriteExceptionTest_message() {
        String errorMessage = "Test error message";
        FileWriteException ex = new FileWriteException(errorMessage);

        assertEquals(errorMessage, ex.getMessage());
        assertNull(ex.getCause());
    }

    @Test
    void fileWriteExceptionTest_messageAndCause() {
        String errorMessage = "Test error message";
        Throwable cause = new Throwable("Test cause");

        FileWriteException ex = new FileWriteException(errorMessage, cause);

        assertEquals(errorMessage, ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
}
