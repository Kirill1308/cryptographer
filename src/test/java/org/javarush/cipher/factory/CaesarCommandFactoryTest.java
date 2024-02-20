package org.javarush.cipher.factory;

import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.command.DecryptCommand;
import org.javarush.cipher.caesar.command.EncryptCommand;
import org.javarush.cipher.caesar.command.HackCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
class CaesarCommandFactoryTest {

    @Test
    void createCommandTest_encrypt() {
        String filepath = "mock path";
        int key = 3;

        CaesarCommandFactory caesarCommandFactory = new CaesarCommandFactory(filepath, key);
        ActionCommand actionCommand = caesarCommandFactory.createCommand(UserAction.ENCRYPT);

        assertInstanceOf(EncryptCommand.class, actionCommand, "createCommand should return an instance of EncryptCommand for ENCRYPT UserAction");
    }

    @Test
    void createCommandTest_decrypt() {
        String filepath = "mock path";
        int key = 3;
        
        CaesarCommandFactory caesarCommandFactory = new CaesarCommandFactory(filepath, key);
        ActionCommand actionCommand = caesarCommandFactory.createCommand(UserAction.DECRYPT);

        assertInstanceOf(DecryptCommand.class, actionCommand, "createCommand should return an instance of DecryptIncognitoCommand for DECRYPT UserAction");
    }
    
    @Test
    void createCommandTest_hack() {
        String filepath = "mock path";
        int key = 3;
        
        CaesarCommandFactory caesarCommandFactory = new CaesarCommandFactory(filepath, key);
        ActionCommand actionCommand = caesarCommandFactory.createCommand(UserAction.HACK);

        assertInstanceOf(HackCommand.class, actionCommand, "createCommand should return an instance of HackCommand for HACK UserAction");
    }
}