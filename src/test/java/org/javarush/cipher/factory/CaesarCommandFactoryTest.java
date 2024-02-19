package org.javarush.cipher.factory;

import org.javarush.cipher.ActionCommand;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.command.DecryptCaesarCommand;
import org.javarush.cipher.caesar.command.EncryptCaesarCommand;
import org.javarush.cipher.caesar.command.HackCaesarCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
class CaesarCommandFactoryTest {

    @Test
    void createCommandTest_encrypt() {
        String filepath = "mock path";
        int key = 3;

        CaesarCommandFactory caesarCommandFactory = new CaesarCommandFactory(filepath, key);
        ActionCommand actionCommand = caesarCommandFactory.createCommand(UserAction.ENCRYPT);

        assertInstanceOf(EncryptCaesarCommand.class, actionCommand, "createCommand should return an instance of EncryptCaesarCommand for ENCRYPT UserAction");
    }

    @Test
    void createCommandTest_decrypt() {
        String filepath = "mock path";
        int key = 3;
        
        CaesarCommandFactory caesarCommandFactory = new CaesarCommandFactory(filepath, key);
        ActionCommand actionCommand = caesarCommandFactory.createCommand(UserAction.DECRYPT);

        assertInstanceOf(DecryptCaesarCommand.class, actionCommand, "createCommand should return an instance of DecryptCaesarCommand for DECRYPT UserAction");
    }
    
    @Test
    void createCommandTest_hack() {
        String filepath = "mock path";
        int key = 3;
        
        CaesarCommandFactory caesarCommandFactory = new CaesarCommandFactory(filepath, key);
        ActionCommand actionCommand = caesarCommandFactory.createCommand(UserAction.HACK);

        assertInstanceOf(HackCaesarCommand.class, actionCommand, "createCommand should return an instance of HackCaesarCommand for HACK UserAction");
    }
}