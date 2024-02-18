package org.javarush.cipher.caesar.command;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javarush.app.AppContext;
import org.javarush.cipher.ActionCommand;
import org.javarush.io.FileService;

@Log4j2
@AllArgsConstructor
public class DecryptCaesarCommand implements ActionCommand {
    private static final FileService fileService = AppContext.getInstanceOf(FileService.class);
    private final String filepath;
    private final int key;

    @Override
    public void execute() {
        log.info("Executing DecryptCaesarCommand...");
        System.out.println("Decrypting...");

        String content = fileService.read(filepath);
        String decryptedContent = decrypt(content, key);
        String destFilepath = generateDecryptedFilePath(filepath);
        fileService.write(destFilepath, decryptedContent);
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

    public static String generateDecryptedFilePath(String filepath) {
        log.info("Generating decrypted filepath...");

        final String DECRYPTED = "[DECRYPTED]";
        int startBracketIndex = filepath.indexOf('[');
        int endBracketIndex = filepath.lastIndexOf(']');

        if (startBracketIndex != -1 && endBracketIndex != -1) {
            String preBracketContent = filepath.substring(0, startBracketIndex);
            String postBracketContent = filepath.substring(endBracketIndex + 1);
            return preBracketContent + DECRYPTED + postBracketContent;
        }

        log.error("Filepath does not contain brackets: " + filepath);
        throw new IllegalArgumentException("Filepath does not contain brackets: " + filepath);
    }
}
