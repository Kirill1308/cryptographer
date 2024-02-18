package org.javarush.cipher.caesar;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.Cipher;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.UserAction;

@Log4j2
public class CaesarCipher implements Cipher {
    private final CipherStrategy strategy;
    public CaesarCipher(UserAction command, String filepath, int key) {
        this.strategy = new CaesarCipherStrategy(command, filepath, key);
    }

    @Override
    public void execute() {
        log.info("Executing CaesarCipher...");
        strategy.execute();
    }
}
