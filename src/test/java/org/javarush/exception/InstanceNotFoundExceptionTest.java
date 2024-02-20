package org.javarush.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InstanceNotFoundExceptionTest {
    @Test
    void testInstanceNotFoundException_WithMessage() {
        String expectedMessage = "Test Message";

        InstanceNotFoundException instanceNotFoundException = new InstanceNotFoundException(expectedMessage);

        assertEquals(expectedMessage, instanceNotFoundException.getMessage());
        assertNull(instanceNotFoundException.getCause());
    }

    @Test
    void testInstanceNotFoundException_WithMessageAndCause() {
        String expectedMessage = "Test Message";
        Throwable expectedCause = new RuntimeException("Cause");

        InstanceNotFoundException instanceNotFoundException = new InstanceNotFoundException(expectedMessage, expectedCause);

        assertEquals(expectedMessage, instanceNotFoundException.getMessage());
        assertEquals(expectedCause, instanceNotFoundException.getCause());
    }
}
