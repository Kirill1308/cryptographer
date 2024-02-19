package org.javarush.app;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.createTempFile;

public class CryptographerApp {
    public static void main(String[] args) throws IOException {
/*        Runner runner = new Runner();
        runner.run(args);*/

        Path tmpFile = createTempFile("test[ENCRYPTED]", ".txt");
        System.out.println(tmpFile.toString());
    }
}
