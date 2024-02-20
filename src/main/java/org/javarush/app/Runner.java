package org.javarush.app;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.CaesarCipher;
import org.javarush.cipher.Cipher;
import org.javarush.cli.CLI;

@Log4j2
public final class Runner {
    public static final String DEFAULT_COMMAND = "command";
    private final CLI cli = AppContext.getInstanceOf(CLI.class);

    public void run(String[] args) {
        if (args != null && (args.length > 0 && args.length < 4)) {
            RunOperation runOperation;
            if (DEFAULT_COMMAND.equalsIgnoreCase(args[0])) {
                runOperation = new NoArgsRun();
            } else {
                runOperation = new ArgsRun(args);
            }
            runOperation.run();
        } else {
            log.warn("Invalid usage. Please provide valid arguments.");
            System.out.println("Invalid usage. Please provide valid arguments.");
        }
    }

    interface RunOperation {
        void run();
    }

    class NoArgsRun implements RunOperation {
        @Override
        public void run() {
            log.info("Running the application without args...");

            UserAction command;
            String filepath;
            int key;
            try {
                command = UserAction.valueOf(cli.getCommand());
                filepath = cli.getFilePath();
                key = (command == UserAction.HACK) ? 0 : cli.getKey();
            } finally {
                cli.closeScanner();
            }
            createAndExecuteCipher(command, filepath, key);
        }
    }

    @AllArgsConstructor
    class ArgsRun implements RunOperation {
        private final String[] args;

        @Override
        public void run() {
            log.info("Running the application with args...");
            String command = args[0];
            String filePath = args[1];
            int key = (args.length == 3) ? Integer.parseInt(args[2]) : 0;
            createAndExecuteCipher(UserAction.valueOf(command), filePath, key);
        }
    }

    private void createAndExecuteCipher(UserAction command, String filepath, int key) {
        Cipher cipher = new CaesarCipher(command, filepath, key);
        cipher.execute();
    }
}
