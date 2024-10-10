package org.javarush.io;

import lombok.extern.log4j.Log4j2;
import org.javarush.exception.FileReadException;
import org.javarush.exception.FileWriteException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Log4j2
public class FileService implements IO {
    @Override
    public String read(String filepath) {
        log.info("Reading file: " + filepath);

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error("Error reading file: " + filepath, e);
            throw new FileReadException("Error reading file: " + filepath, e);
        }
        return sb.toString();
    }
    @Override
    public void write(String filepath, String content) {
        log.info("Writing to file: " + filepath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(content);
        } catch (IOException e) {
            log.error("Error writing to file: " + filepath, e);
            throw new FileWriteException("Error writing to file: " + filepath, e);
        }
    }
}
