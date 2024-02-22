package org.javarush.app.runner;

import lombok.extern.log4j.Log4j2;
import org.javarush.app.AppContext;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.UserAction;
import org.javarush.cli.CLI;

@Log4j2
public class NoArgsRun extends RunOperation {
    private final CLI cli = AppContext.getInstanceOf(CLI.class);
    private final UserAction command;

    public NoArgsRun(CipherStrategy strategy) {
        super(strategy);
        command = cli.getCommand();
    }

    @Override
    protected UserAction getCommand() {
        return this.command;
    }

    @Override
    protected String getFilePath() {
        return cli.getFilePath();
    }

    @Override
    protected int getKey() {
        return (command == UserAction.HACK) ? 0 : cli.getKey();
    }

    @Override
    public void run() {
        try {
            super.run();
        } finally {
            cli.closeScanner();
        }
    }
}
