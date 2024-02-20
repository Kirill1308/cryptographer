package org.javarush.cipher.caesar;

import lombok.AllArgsConstructor;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.factory.CaesarCommandFactory;

@AllArgsConstructor
public class CaesarCipherStrategy implements CipherStrategy {
    private final UserAction command;
    private final String filepath;
    private final int key;

    @Override
    public void execute() {
        ActionCommand actionCommand = new CaesarCommandFactory(filepath, key).createCommand(command);
        executeCommand(actionCommand);
    }

    private void executeCommand(ActionCommand command) {
        command.execute();
    }
}
