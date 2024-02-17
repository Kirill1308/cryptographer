package org.javarush.io;

import org.javarush.exception.FileReadException;
import org.javarush.exception.FileWriteException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService implements IO {
    @Override
    public String read(String filepath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new FileReadException("Error reading file: " + filepath, e);
        }
        return sb.toString();
    }


    @Override
    public void write(String filepath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new FileWriteException("Error writing to file: " + filepath, e);
        }
    }
}
