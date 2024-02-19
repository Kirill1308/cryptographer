package org.javarush.cipher.incognito.command;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;

@AllArgsConstructor
public class DecryptIncognitoCommand implements ActionCommand {
    private final String filepath;
    private final int key;

    @Override
    public void execute() {
        System.out.println("Decrypting with IncognitoCipher...");
    }
}
