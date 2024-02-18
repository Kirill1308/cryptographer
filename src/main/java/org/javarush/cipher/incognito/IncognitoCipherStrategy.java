package org.javarush.cipher.incognito;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.factory.IncognitoCommandFactory;

@AllArgsConstructor
public class IncognitoCipherStrategy implements CipherStrategy {
    private final UserAction command;
    private final String filepath;
    private final int key;

    @Override
    public void execute() {
        ActionCommand cipherCommand = new IncognitoCommandFactory(filepath, key).createCommand(command);
        executeCommand(cipherCommand);
    }

    private void executeCommand(ActionCommand command) {
        command.execute();
    }
}
