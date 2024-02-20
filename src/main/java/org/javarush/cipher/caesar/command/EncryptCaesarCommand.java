package org.javarush.cipher.caesar.command;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.ActionCommand;
import org.javarush.io.FilePathHelper;

@Log4j2
public class EncryptCaesarCommand extends ActionCommand {
    public EncryptCaesarCommand(String filepath, int key) {
        super(filepath, key);
    }

    @Override
    protected String processContent(String content) {
        System.out.println("Encryption complete!");
        return encrypt(content, key);
    }

    @Override
    protected String getDestFilePath(String filepath) {
        log.info("Generating encrypted filepath...");
        final String ENCRYPTED_TAG = "[ENCRYPTED]";

        return FilePathHelper.generateTaggedFilePath(filepath, ENCRYPTED_TAG);
    }

    private String encrypt(String content, int key) {
        log.info("Encrypting content...");

        StringBuilder encryptedText = new StringBuilder();
        for (char c : content.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) (base + (c - base + key) % 26));
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }
}
