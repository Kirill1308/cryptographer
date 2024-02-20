package org.javarush.app;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.UserAction;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
class RunnerTest {
    @Test
    void run_withArgs() {
        Runner runner = new Runner();
        String[] args = {"ENCRYPT", "src/test/resources/text.txt", "3"};
        runner.run(args);

        assertEquals(UserAction.ENCRYPT, UserAction.valueOf(args[0]));
        assertEquals("src/test/resources/text.txt", (args[1]));
        assertEquals(Integer.parseInt(args[2]), 3);
    }

    @Test
    void run_withoutArgs() {
        Runner runner = new Runner();
        String[] args = {};
        runner.run(args);
    }

    @Test
    void testRunWithArgsGreaterThanLimit() {
        String[] args = {"arg1", "arg2", "arg3", "arg4"};
        Runner runner = new Runner();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        runner.run(args);

        System.setOut(originalOut);

        String expected = "Invalid usage. Please provide valid arguments." + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }
}
