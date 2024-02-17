package org.javarush.cipher;

import lombok.AllArgsConstructor;
import org.javarush.app.AppContext;
import org.javarush.command.ActionCommand;
import org.javarush.command.UserAction;

@AllArgsConstructor
public class CaesarCipher implements Cipher{
    private final String command;
    private final String filepath;
    private final int key;

    @Override
    public void execute() {
        ActionCommand action = AppContext.getActionCommands().get(UserAction.valueOf(command));
        action.execute(filepath, key);
    }
}
