package org.javarush.cli;

import java.util.Scanner;

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);
    public String getCommand(){
        System.out.print("Enter command: ");
        return scanner.nextLine().toUpperCase();
    }

    public String getFilePath(){
        System.out.print("Enter file path: ");
        return scanner.nextLine();
    }

    public int getKey(){
        System.out.print("Enter key: ");
        return scanner.nextInt();
    }
}
