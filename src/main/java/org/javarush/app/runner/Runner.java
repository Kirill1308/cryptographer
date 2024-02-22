package org.javarush.app.runner;


import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.caesar.CaesarCipherStrategy;

@Log4j2
public final class Runner {
    public void run(String[] args) {
        CipherStrategy strategy = new CaesarCipherStrategy();
        RunOperation runOperation = new ArgsRun(args, strategy);
        runOperation.run();
    }
}
