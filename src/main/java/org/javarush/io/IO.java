package org.javarush.io;

public interface IO {
    String read(String filepath);

    void write(String filepath, String content);
}
