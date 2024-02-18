package org.javarush.cipher.incognito;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.Cipher;
import org.javarush.cipher.UserAction;

@Log4j2
public class IncognitoCipher implements Cipher {
    private final IncognitoCipherStrategy strategy;

    public IncognitoCipher(UserAction command, String filepath, int key) {
        this.strategy = new IncognitoCipherStrategy(command, filepath, key);
    }

    @Override
    public void execute() {
        log.info("Executing IncognitoCipher...");
        strategy.execute();
    }
}
