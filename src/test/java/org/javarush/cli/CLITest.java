package org.javarush.cli;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.javarush.cipher.UserAction;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CLITest {
    @Test
    void getCommand_withValidCommands() {
        String commandInput = "ENCRYPT\nDECRYPT\nHACK\n";
        InputStream in = new ByteArrayInputStream(commandInput.getBytes());
        System.setIn(in);

        CLI cliInstance = new CLI();

        String command = cliInstance.getCommand();
        assertEquals(UserAction.ENCRYPT.name(), command);

        command = cliInstance.getCommand();
        assertEquals(UserAction.DECRYPT.name(), command);

        command = cliInstance.getCommand();
        assertEquals(UserAction.HACK.name(), command);
    }
    @Test
    void getPath_withValidPath() {
        String pathInput = "src/main/resources/text.txt";
        InputStream in = new ByteArrayInputStream(pathInput.getBytes());
        System.setIn(in);

        CLI cliInstance = new CLI();

        String path = cliInstance.getFilePath();
        assertEquals("src/main/resources/text.txt", path);
    }

    @Test
    void getKey_withValidKey() {
        String keyInput = "3";
        InputStream in = new ByteArrayInputStream(keyInput.getBytes());
        System.setIn(in);

        CLI cliInstance = new CLI();

        int key = cliInstance.getKey();
        assertEquals(3, key);
    }

    @Test
    void getKey_withInvalidKey() {
        String keyInput = "0\n-1\n3";
        InputStream in = new ByteArrayInputStream(keyInput.getBytes());
        System.setIn(in);

        CLI cliInstance = new CLI();

        int key = cliInstance.getKey();
        assertEquals(3, key);
    }

    @Test
    void closeScanner_success() throws IllegalAccessException, NoSuchFieldException {
        CLI cliInstance = new CLI();

        cliInstance.closeScanner();

        Field scannerField = CLI.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);
        Object scannerValue = scannerField.get(cliInstance);
        assertNull(((Scanner) scannerValue).ioException());
    }

    @AfterEach
    public void revertSystemIn() {
        System.setIn(System.in);
    }
}
