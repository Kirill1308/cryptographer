package org.javarush.cipher.caesar.command;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.ActionCommand;
import org.javarush.io.FilePathHelper;

@Log4j2
public class DecryptCaesarCommand extends ActionCommand {
    public DecryptCaesarCommand(String filepath, int key) {
        super(filepath, key);
    }

    @Override
    protected String processContent(String content) {
        System.out.println("Decryption complete!");
        return decrypt(content, key);
    }

    @Override
    protected String getDestFilePath(String filepath) {
        log.info("Generating decrypted filepath...");
        final String DECRYPTED_TAG = "[DECRYPTED]";

        return FilePathHelper.generateTaggedFilePath(filepath, DECRYPTED_TAG);
    }

    public static String decrypt(String content, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : content.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decryptedText.append((char) (base + (c - base - key + 26) % 26));
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
}
