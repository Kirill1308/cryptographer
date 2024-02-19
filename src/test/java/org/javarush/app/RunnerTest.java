package org.javarush.app;

import org.javarush.cipher.UserAction;
import org.javarush.cli.CLI;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RunnerTest {
/*    @Test
    void run_noArgs() {
        String[] args = {};
        CLI mockCli = mock(CLI.class);

        when(AppContext.getInstanceOf(CLI.class)).thenReturn(mockCli);
        when(mockCli.getCommand()).thenReturn(UserAction.ENCRYPT.name());
        when(mockCli.getFilePath()).thenReturn("src/main/resources/text.txt");
        when(mockCli.getKey()).thenReturn(3);

        Runner runner = new Runner();
        runner.run(args);

        verify(mockCli, times(1)).getCommand();
        verify(mockCli, times(1)).getFilePath();
        verify(mockCli, times(1)).getKey();
        verify(mockCli, times(1)).closeScanner();
    }*/

/*    @Test
    void run_noArgs1() {
        String input = "ENCRYPT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Runner runner = mock(Runner.class);
        CLI mockCLI = mock(CLI.class);
        runner.run(new String[]{});

        assertEquals(UserAction.ENCRYPT.name(), mockCLI.getCommand());
        verify(mockCLI, times(1)).getCommand();
    }*/

    @Test
    void run_withArgs() {
        Runner runner = new Runner();
        String[] args = {"ENCRYPT", "src/main/resources/text.txt", "3"};
        runner.run(args);

        assertEquals(UserAction.ENCRYPT, UserAction.valueOf(args[0]));
        assertEquals("src/main/resources/text.txt", (args[1]));
        assertEquals(Integer.parseInt(args[2]), 3);
    }
}
