package org.javarush.app;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.UserAction;
import org.javarush.cipher.caesar.CaesarCipher;
import org.javarush.cipher.Cipher;
import org.javarush.cli.CLI;

@Log4j2
public final class Runner {
    private final CLI cli = AppContext.getInstanceOf(CLI.class);

    public void run(String[] args) {
        RunOperation runOperation;
        if (args.length == 0) {
            runOperation = new NoArgsRun();
        } else {
            runOperation = new ArgsRun(args);
        }
        runOperation.run();
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
                key = cli.getKey();
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
            int key = 0;
            if (args.length == 3) {
                key = Integer.parseInt(args[2]);
            }
            createAndExecuteCipher(UserAction.valueOf(command), filePath, key);
        }
    }

    private void createAndExecuteCipher(UserAction command, String filepath, int key) {
        Cipher cipher = new CaesarCipher(command, filepath, key);
        cipher.execute();
    }
}
