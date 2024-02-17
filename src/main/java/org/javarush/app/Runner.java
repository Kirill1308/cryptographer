package org.javarush.app;

import org.javarush.cipher.CaesarCipher;
import org.javarush.cipher.Cipher;
import org.javarush.cli.CLI;

public final class Runner {
    private static final CLI cli = AppContext.getInstanceOf(CLI.class);
    public void run() {
        String command = cli.getCommand();
        String filepath = cli.getFilePath();
        int key = cli.getKey();

        Cipher cipher = new CaesarCipher(command, filepath, key);
        cipher.execute();
    }
}
