package org.javarush.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InstanceNotFoundExceptionTest {
    @Test
    void instanceNotFoundException_message() {
        String errorMessage = "Test error message";

        InstanceNotFoundException instanceNotFoundException = new InstanceNotFoundException(errorMessage);

        assertEquals(errorMessage, instanceNotFoundException.getMessage());
        assertNull(instanceNotFoundException.getCause());
    }

    @Test
    void instanceNotFoundException_messageAndCause() {
        String errorMessage = "Test error message";
        Throwable cause = new Throwable("Test cause");

        InstanceNotFoundException instanceNotFoundException = new InstanceNotFoundException(errorMessage, cause);

        assertEquals(errorMessage, instanceNotFoundException.getMessage());
        assertEquals(cause, instanceNotFoundException.getCause());
    }
}
