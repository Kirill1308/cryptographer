package org.javarush.io;

import org.javarush.exception.FileReadException;
import org.javarush.exception.FileWriteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileServiceTest {
    private static final FileService fileService = new FileService();

    @Test
    void read_success() {
        String expectedContent = "Hello, World!";
        try {
            Path tempFile = Files.createTempFile("tempFile", ".txt");
            Files.writeString(tempFile, expectedContent);

            String actualContent = fileService.read(tempFile.toString());

            assertEquals(expectedContent, actualContent.trim());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void read_FileReadException() {

        try (BufferedReader mockReader = mock(BufferedReader.class)) {
            when(mockReader.readLine()).thenThrow(new IOException());
        } catch (IOException e) {
            fail(e.getMessage());
        }

        assertThrows(FileReadException.class, () -> {
            fileService.read("path/to/non/existent/file");
        });
    }

    @Test
    void write_fileWriteException() {
        String tempFilePath = "/invalid/path/file.txt";
        String content = "javarush";

        assertThrows(FileWriteException.class, () -> fileService.write(tempFilePath, content));
    }

    @Test
    void write_success() throws IOException {
        String tempFilePath = "TestFile.txt";
        String content = "javarush";

        fileService.write(tempFilePath, content);

        BufferedReader reader = new BufferedReader(new FileReader(tempFilePath));
        String line = reader.readLine();
        assertEquals(content, line, "File content does not match expected output");

        new FileWriter(tempFilePath, false).close();
    }
}
