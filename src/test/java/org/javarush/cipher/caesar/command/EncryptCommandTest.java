package org.javarush.cipher.caesar.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptCommandTest {
    @Test
    void processContent() {
        String testContent = "a";
        String expected = "d";
        EncryptCommand encryptCommand = new EncryptCommand("", 3);
        String actual = encryptCommand.processContent(testContent);
        assertEquals(expected, actual, "Encrypted content doesn't match expected content");

        testContent = "Z";
        expected = "C";
        actual = encryptCommand.processContent(testContent);
        assertEquals(expected, actual, "Encrypted content doesn't match expected content");

        testContent = "4";
        expected = "4";
        actual = encryptCommand.processContent(testContent);
        assertEquals(expected, actual, "Encrypted content doesn't match expected content");
    }
}
