package org.javarush.app;

import org.javarush.cli.CLI;
import org.javarush.command.ActionCommand;
import org.javarush.command.BruteForceCommand;
import org.javarush.command.DecryptCommand;
import org.javarush.command.EncryptCommand;
import org.javarush.command.UserAction;
import org.javarush.io.FileService;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public final class AppContext {
    private static final Map<Class<?>, Object> CLASS_TO_OBJECT_INSTANCE = new HashMap<>();
    private static final Map<UserAction, ActionCommand> ACTION_COMMANDS = new EnumMap<>(UserAction.class);

    private AppContext() {
    }

    static {
        CLASS_TO_OBJECT_INSTANCE.put(FileService.class, new FileService());
        CLASS_TO_OBJECT_INSTANCE.put(CLI.class, new CLI());

        ACTION_COMMANDS.put(UserAction.ENCRYPT, new EncryptCommand());
        ACTION_COMMANDS.put(UserAction.DECRYPT, new DecryptCommand());
        ACTION_COMMANDS.put(UserAction.BRUTE_FORCE, new BruteForceCommand());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstanceOf(Class<T> aClass) {
        Object object = CLASS_TO_OBJECT_INSTANCE.get(aClass);
        if (isNull(object)) {
            //throw new InstanceNotFoundException("No instance found for class " + aClass.getName());
        }
        return (T) object;
    }

    public static Map<UserAction, ActionCommand> getActionCommands() {
        return ACTION_COMMANDS;
    }
}
