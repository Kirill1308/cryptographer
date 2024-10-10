package org.javarush.cipher;

public interface CipherStrategy {
    void execute(UserAction command, String filepath, int key);
}
