package org.javarush.cipher.caesar.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecryptCaesarCommandTest {

    @Test
    void decrypt() {
        String decrypted = DecryptCaesarCommand.decrypt("abc", 2);
        assertEquals(decrypted, ("yza"));
    }

    @Test
    void generateDecryptedFilePath() {
        String newPath = DecryptCaesarCommand.generateDecryptedFilePath("path[subpath]morepath");
        assertEquals(newPath, ("path[DECRYPTED]morepath"));
    }
}