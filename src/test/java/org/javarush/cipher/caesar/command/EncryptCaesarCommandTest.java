package org.javarush.cipher.caesar.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptCaesarCommandTest {
    @Test
    void processContent_encryptSingleSpecialCharacter() {
        String testContent = "a";
        String expected = "d";
        EncryptCaesarCommand encryptCommand = new EncryptCaesarCommand("", 3);
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
