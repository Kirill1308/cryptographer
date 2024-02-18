package org.javarush.cipher.caesar.command;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javarush.app.AppContext;
import org.javarush.cipher.ActionCommand;
import org.javarush.io.FileService;

@Log4j2
@AllArgsConstructor
public class EncryptCaesarCommand implements ActionCommand {
    private static final FileService fileService = AppContext.getInstanceOf(FileService.class);
    private final String filepath;
    private final int key;
    @Override
    public void execute() {
        log.info("Executing EncryptCaesarCommand...");

        System.out.println("Encrypting...");
        String content = fileService.read(filepath);
        String encryptedContent = encrypt(content, key);
        String destFilepath = filepath + "[ENCRYPTED]";
        fileService.write(destFilepath, encryptedContent);
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
