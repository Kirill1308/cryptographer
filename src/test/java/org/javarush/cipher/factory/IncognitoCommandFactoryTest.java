package org.javarush.cipher.factory;

import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.incognito.command.DecryptIncognitoCommand;
import org.javarush.cipher.incognito.command.EncryptIncognitoCommand;
import org.javarush.cipher.incognito.command.HackIncognitoCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class IncognitoCommandFactoryTest {
    @Test
    void createCommand_encryptCommand() {
        String filePath = "someFilePath";
        int key = 3;
        IncognitoCommandFactory factory = new IncognitoCommandFactory(filePath, key);
        UserAction userAction = UserAction.ENCRYPT;

        ActionCommand result = factory.createCommand(userAction);

        assertInstanceOf(EncryptIncognitoCommand.class, result, "Returned command does not match the expected EncryptIncognitoCommand instance");
    }

    @Test
    void createCommand_decryptCommand() {
        String filePath = "someOtherfilePath";
        int key = 7;
        IncognitoCommandFactory factory = new IncognitoCommandFactory(filePath, key);
        UserAction userAction = UserAction.DECRYPT;

        ActionCommand result = factory.createCommand(userAction);

        assertInstanceOf(DecryptIncognitoCommand.class, result, "Returned command does not match the expected DecryptIncognitoCommand instance");
    }

    @Test
    void createCommand_hackCommand() {
        String filepath = "yetAnotherFilePath";
        int key = 0;
        IncognitoCommandFactory factory = new IncognitoCommandFactory(filepath, key);
        UserAction userAction = UserAction.HACK;

        ActionCommand result = factory.createCommand(userAction);

        assertInstanceOf(HackIncognitoCommand.class, result, "Returned command does not match the expected HackIncognitoCommand instance");
    }
}