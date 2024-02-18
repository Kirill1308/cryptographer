package org.javarush.cipher.factory;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.command.DecryptCaesarCommand;
import org.javarush.cipher.caesar.command.HackCaesarCommand;
import org.javarush.cipher.incognito.command.EncryptIncognitoCommand;

@AllArgsConstructor
public class IncognitoCommandFactory implements CommandFactory {
    private final String filepath;
    private final int key;

    @Override
    public ActionCommand createCommand(UserAction command) {
        return switch (command) {
            case ENCRYPT -> new EncryptIncognitoCommand(filepath, key);
            case DECRYPT -> new DecryptCaesarCommand(filepath, key);
            case HACK -> new HackCaesarCommand(filepath);
        };
    }
}
