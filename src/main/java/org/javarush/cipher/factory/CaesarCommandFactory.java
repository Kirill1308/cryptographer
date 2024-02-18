package org.javarush.cipher.factory;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.command.DecryptCaesarCommand;
import org.javarush.cipher.caesar.command.EncryptCaesarCommand;
import org.javarush.cipher.caesar.command.HackCaesarCommand;

@AllArgsConstructor
public class CaesarCommandFactory implements CommandFactory {
    private final String filepath;
    private final int key;

    @Override
    public ActionCommand createCommand(UserAction command) {
        return switch (command) {
            case ENCRYPT -> new EncryptCaesarCommand(filepath, key);
            case DECRYPT -> new DecryptCaesarCommand(filepath, key);
            case HACK -> new HackCaesarCommand(filepath);
        };
    }
}
