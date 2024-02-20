package org.javarush.cipher.incognito;

import org.javarush.cipher.UserAction;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Unit test for {@link org.javarush.cipher.incognito.IncognitoCipher}.
 *
 * This class contains test cases for the {@link org.javarush.cipher.incognito.IncognitoCipher#execute()} method.
 */
public class IncognitoCipherTest {
    /**
     * This test ensures that the {@code execute} method correctly delegates to the
     * {@link org.javarush.cipher.incognito.IncognitoCipherStrategy#execute()} method.
     */
/*    @Test
    public void testExecute() {
        // Arrange
        IncognitoCipherStrategy mockedStrategy = mock(IncognitoCipherStrategy.class);
        IncognitoCipher incognitoCipher = new IncognitoCipher(mock(UserAction.class), "filepath", 0) {
            // we're overwriting method to return our mocked object
        };

        // Act
        incognitoCipher.execute();

        // Assert
        // Verify that the execute method was called on our mock object (which means it was called through incognitoCipher)
        verify(mockedStrategy, times(1)).execute();
    }*/
}