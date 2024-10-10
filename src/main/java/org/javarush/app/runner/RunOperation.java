package org.javarush.app.runner;

import lombok.AllArgsConstructor;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.UserAction;

@AllArgsConstructor
public abstract class RunOperation {
    protected abstract UserAction getCommand();

    protected abstract String getFilePath();

    protected abstract int getKey();

    private final CipherStrategy strategy;

    public void run() {
        UserAction command = getCommand();
        String filepath = getFilePath();
        int key = getKey();
        strategy.execute(command, filepath, key);
    }
}
