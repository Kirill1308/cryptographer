package org.javarush.app.runner;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.CipherStrategy;
import org.javarush.cipher.UserAction;

@Log4j2
class ArgsRun extends RunOperation {
    private static final int HACK_VALUE = 0;
    private final String[] args;

    public ArgsRun(String[] args, CipherStrategy strategy) {
        super(strategy);
        this.args = args;
    }

    @Override
    protected UserAction getCommand() {
        return UserAction.valueOf(args[0].toUpperCase());
    }

    @Override
    protected String getFilePath() {
        return args[1];
    }

    @Override
    protected int getKey() {
        return (args.length == 3) ? Integer.parseInt(args[2]) : HACK_VALUE;
    }

    @Override
    public void run() {
        try {
            super.run();
        } catch (IllegalArgumentException e) {
            log.error("Invalid usage. Please provide valid arguments.");
            System.out.println("Invalid usage. Please provide valid arguments.");
        }
    }
}
