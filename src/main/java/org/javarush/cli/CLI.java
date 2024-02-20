package org.javarush.cli;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.UserAction;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

@Log4j2
public class CLI {
    private final Scanner scanner = new Scanner(System.in);

    public String getCommand() {
        do {
            log.info("Enter command from user...");
            System.out.print("Enter command: ");

            String command = scanner.nextLine().toUpperCase();
            boolean isValid = Arrays.stream(UserAction.values()).anyMatch(v -> v.name().equalsIgnoreCase(command));
            if (isValid) {
                return command;
            } else {
                log.warn("User entered an invalid command!");
                System.out.println("Invalid command! Please enter a valid command." + Arrays.toString(UserAction.values()));
            }
        } while (true);
    }

    public String getFilePath() {
        String filePath;
        do {
            log.info("Enter file path from user...");
            System.out.print("Enter file path: ");

            filePath = scanner.nextLine();
            if (!Files.exists(Paths.get(filePath))) {
                log.warn("User entered an invalid file path!\n" + filePath + " does not exist.");
                System.out.println("File does not exist! Please enter a valid file path.");
            }
        } while (!Files.exists(Paths.get(filePath)));
        return filePath;
    }

    public int getKey() {
        int key;
        do {
            log.info("Enter key from user...");
            System.out.print("Enter key: ");

            key = scanner.nextInt();
            if (key <= 0) {
                log.warn("User entered an invalid key!\n" + key + " is not a valid key.");
                System.out.println("Invalid key! Please enter a valid key. Key must be greater than 0.");
            }
        } while (key <= 0);
        return key;
    }

    public void closeScanner() {
        scanner.close();
    }
}
