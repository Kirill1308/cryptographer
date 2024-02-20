package org.javarush.cipher.caesar.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecryptIncognitoCommandTest {
    @Test
    void processContent() {
        String testContent = "d";
        String expected = "a";
        DecryptCommand decryptCommand = new DecryptCommand("", 3);
        String actual = decryptCommand.processContent(testContent);
        assertEquals(expected, actual, "Decrypted content doesn't match expected content");

        testContent = "A";
        expected = "X";
        actual = decryptCommand.processContent(testContent);
        assertEquals(expected, actual, "Decrypted content doesn't match expected content");

        testContent = "4";
        expected = "4";
        actual = decryptCommand.processContent(testContent);
        assertEquals(expected, actual, "Decrypted content doesn't match expected content");
    }
}
