package org.javarush.cipher.caesar.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecryptIncognitoCommandTest {
    @Test
    void processContent_decryptSingleSpecialCharacter() {
        String testContent = "d";
        String expected = "a";
        DecryptCaesarCommand decryptCommand = new DecryptCaesarCommand("", 3);
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

    @Test
    void getDestFilePath_validFilePath_returnsExpectedFilePath() {
        String initialFilePath = "C:\\Users\\User\\Desktop\\file.txt";
        DecryptCaesarCommand decryptCaesarCommand = new DecryptCaesarCommand(initialFilePath, 5);
        String expected = "C:\\Users\\User\\Desktop\\file.txt[DECRYPTED]";
        String actual = decryptCaesarCommand.getDestFilePath(initialFilePath);

        assertEquals(expected, actual);
    }

    @Test
    void getDestFilePath_decryptsFileWithCorrectOffset() {
        String initialFilePath = "";
        DecryptCaesarCommand decryptCaesarCommand = new DecryptCaesarCommand(initialFilePath, 5);
        String expected = "[DECRYPTED]";
        String actual = decryptCaesarCommand.getDestFilePath(initialFilePath);

        assertEquals(expected, actual);
    }

    @Test
    void getDestFilePath_shouldHandleFilenameOnly() {
        String initialFilePath = "file.txt";
        DecryptCaesarCommand decryptCaesarCommand = new DecryptCaesarCommand(initialFilePath, 5);
        String expected = "file.txt[DECRYPTED]";
        String actual = decryptCaesarCommand.getDestFilePath(initialFilePath);
        assertEquals(expected, actual);
    }
}
