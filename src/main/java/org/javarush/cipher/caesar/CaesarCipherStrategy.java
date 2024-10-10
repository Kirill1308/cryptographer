package org.javarush.cipher.caesar;

import lombok.AllArgsConstructor;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.factory.CaesarCommandFactory;

@AllArgsConstructor
public class CaesarCipherStrategy implements CipherStrategy {
    @Override
    public void execute(UserAction command, String filepath, int key) {
        ActionCommand caesarCommand = new CaesarCommandFactory(filepath, key).createCommand(command);
        caesarCommand.execute();
    }
}
