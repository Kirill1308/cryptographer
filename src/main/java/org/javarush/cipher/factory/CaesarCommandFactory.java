package org.javarush.cipher.factory;

import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.caesar.command.DecryptCaesarCommand;
import org.javarush.cipher.caesar.command.EncryptCaesarCommand;
import org.javarush.cipher.caesar.command.HackCaesarCommand;

public class CaesarCommandFactory extends AbstractCommandFactory {
    public CaesarCommandFactory(String filepath, int key) {
        super(filepath, key);
    }

    @Override
    protected ActionCommand createEncryptCommand() {
        return new EncryptCaesarCommand(filepath, key);
    }

    @Override
    protected ActionCommand createDecryptCommand() {
        return new DecryptCaesarCommand(filepath, key);
    }

    @Override
    protected ActionCommand createHackCommand() {
        return new HackCaesarCommand(filepath);
    }
}
