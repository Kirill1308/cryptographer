package org.javarush.app;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.CaesarCipher;
import org.javarush.cipher.Cipher;
import org.javarush.cli.CLI;

@Log4j2
public final class Runner {
    private static final CLI cli = AppContext.getInstanceOf(CLI.class);

    public void run() {
        log.info("Running the application...");

        UserAction command = UserAction.valueOf(cli.getCommand());
        String filepath = cli.getFilePath();
        int key = cli.getKey();

        Cipher cipher = new CaesarCipher(command, filepath, key);
        cipher.execute();
    }
}
