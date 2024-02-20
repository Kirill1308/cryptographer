package org.javarush.cipher.factory;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.command.DecryptCommand;
import org.javarush.cipher.caesar.command.EncryptCommand;
import org.javarush.cipher.caesar.command.HackCommand;

@AllArgsConstructor
public class CaesarCommandFactory implements CommandFactory {
    private final String filepath;
    private final int key;

    @Override
    public ActionCommand createCommand(UserAction command) {
        return switch (command) {
            case ENCRYPT -> new EncryptCommand(filepath, key);
            case DECRYPT -> new DecryptCommand(filepath, key);
            case HACK -> new HackCommand(filepath);
        };
    }
}
