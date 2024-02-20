package org.javarush.cipher.factory;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;

@AllArgsConstructor
public abstract class AbstractCommandFactory {
    protected final String filepath;
    protected final int key;

    protected abstract ActionCommand createEncryptCommand();

    protected abstract ActionCommand createDecryptCommand();

    protected abstract ActionCommand createHackCommand();

    public ActionCommand createCommand(UserAction command) {
        return switch (command) {
            case ENCRYPT -> createEncryptCommand();
            case DECRYPT -> createDecryptCommand();
            case HACK -> createHackCommand();
        };
    }
}
