package org.javarush.cipher.caesar.command;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.javarush.app.AppContext;
import org.javarush.cipher.ActionCommand;
import org.javarush.io.FileService;

@Log4j2
@AllArgsConstructor
public abstract class CaesarCommand implements ActionCommand {
    private static final FileService fileService = AppContext.getInstanceOf(FileService.class);
    protected final String filepath;
    protected final int key;

    @Override
    public void execute() {
        log.info("Executing " + this.getClass().getSimpleName() + "...");
        System.out.println("\nProcessing...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Thread sleep interrupted in {}", this.getClass().getSimpleName(), e);
            Thread.currentThread().interrupt();
        }

        String content = fileService.read(filepath);
        String processedContent = processContent(content);
        String destFilepath = getDestFilePath(filepath);
        fileService.write(destFilepath, processedContent);
    }

    protected abstract String processContent(String content);

    protected abstract String getDestFilePath(String filepath);
}
