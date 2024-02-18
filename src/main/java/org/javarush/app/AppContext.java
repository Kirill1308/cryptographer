package org.javarush.app;

import org.javarush.cli.CLI;
import org.javarush.exception.InstanceNotFoundException;
import org.javarush.io.FileService;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public final class AppContext {
    private static final Map<Class<?>, Object> CLASS_TO_OBJECT_INSTANCE = new HashMap<>();

    private AppContext() {
    }

    static {
        CLASS_TO_OBJECT_INSTANCE.put(FileService.class, new FileService());
        CLASS_TO_OBJECT_INSTANCE.put(CLI.class, new CLI());
    }

    public static <T> T getInstanceOf(Class<T> aClass) {
        Object object = CLASS_TO_OBJECT_INSTANCE.get(aClass);
        if (isNull(object)) {
            throw new InstanceNotFoundException("No instance found for class " + aClass.getName());
        }
        return aClass.cast(object);
    }
}
