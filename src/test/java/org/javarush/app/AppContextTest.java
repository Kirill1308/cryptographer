package org.javarush.app;

import org.javarush.exception.InstanceNotFoundException;
import org.javarush.io.FileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppContextTest {

    @Test
    void getInstanceOf_instanceAvailable() {
        Class<FileService> clazz = FileService.class;

        FileService instance = AppContext.getInstanceOf(clazz);

        Assertions.assertNotNull(instance, "Expected instance to be not null");
        Assertions.assertInstanceOf(FileService.class, instance, "Expected instance to be of FileService class");
    }

    @Test
    void getInstanceOf_instanceNotFound() {
        Class<String> clazz = String.class;

        Assertions.assertThrows(InstanceNotFoundException.class, () -> AppContext.getInstanceOf(clazz),
                "Expected getInstanceOf to throw InstanceNotFoundException for unavailable class");
    }
}
