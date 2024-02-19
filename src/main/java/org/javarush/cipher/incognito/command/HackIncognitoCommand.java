package org.javarush.cipher.incognito.command;

import lombok.AllArgsConstructor;
import org.javarush.cipher.ActionCommand;

@AllArgsConstructor
public class HackIncognitoCommand implements ActionCommand {
    private final String filepath;

    @Override
    public void execute() {
        System.out.println("Hacking IncognitoCipher...");
    }
}
