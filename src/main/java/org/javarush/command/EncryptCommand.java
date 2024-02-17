package org.javarush.command;

import org.javarush.app.AppContext;
import org.javarush.io.FileService;

public class EncryptCommand implements ActionCommand {
    private static final FileService fileService = AppContext.getInstanceOf(FileService.class);

    @Override
    public void execute(String filepath, int key) {
        System.out.println("Encrypting...");
        String content = fileService.read(filepath);
        String encryptedContent = encrypt(content, key);
        String destFilepath = filepath + "[ENCRYPTED]";
        fileService.write(destFilepath, encryptedContent);
    }

    private String encrypt(String content, int key) {
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
