package org.javarush.cli;

import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class CLI {
    private static final Scanner scanner = new Scanner(System.in);
    public String getCommand(){
        log.info("Getting command from user...");
        System.out.print("Enter command: ");

        return scanner.nextLine().toUpperCase();
    }

    public String getFilePath(){
        log.info("Getting file path from user...");
        System.out.print("Enter file path: ");

        return scanner.nextLine();
    }

    public int getKey(){
        log.info("Getting key from user...");
        System.out.print("Enter key: ");

        return scanner.nextInt();
    }
}
