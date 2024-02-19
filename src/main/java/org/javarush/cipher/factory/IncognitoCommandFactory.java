package org.javarush.cipher.factory;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.incognito.command.DecryptIncognitoCommand;
import org.javarush.cipher.incognito.command.EncryptIncognitoCommand;
import org.javarush.cipher.incognito.command.HackIncognitoCommand;

@AllArgsConstructor
public class IncognitoCommandFactory implements CommandFactory {
    private final String filepath;
    private final int key;

    @Override
    public ActionCommand createCommand(UserAction command) {
        return switch (command) {
            case ENCRYPT -> new EncryptIncognitoCommand(filepath, key);
            case DECRYPT -> new DecryptIncognitoCommand(filepath, key);
            case HACK -> new HackIncognitoCommand(filepath);
        };
    }
}
