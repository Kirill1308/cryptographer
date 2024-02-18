package org.javarush.cipher.factory;

import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;

public interface CommandFactory {
    ActionCommand createCommand(UserAction command);
}
