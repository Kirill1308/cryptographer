package org.javarush.command;

import org.javarush.app.AppContext;
import org.javarush.io.FileService;

import java.util.HashMap;
import java.util.Map;

public class BruteForceCommand implements ActionCommand {
    private static final FileService fileService = AppContext.getInstanceOf(FileService.class);

    @Override
    public void execute(String filepath, int key) {
        System.out.println("Brute forcing...");
        String content = fileService.read(filepath);
        String bruteForcedContent = bruteForce(content);
        String destFilepath = DecryptCommand.generateDecryptedFilePath(filepath);
        fileService.write(destFilepath, bruteForcedContent);
    }

    private String bruteForce(String encryptedText) {
        String bestDecryption = "";
        double bestScore = Double.MAX_VALUE;

        for (int shift = 1; shift <= 25; shift++) {
            String decryption = DecryptCommand.decrypt(encryptedText, shift);
            double score = calculateFrequencyScore(decryption);

            if (score < bestScore) {
                bestScore = score;
                bestDecryption = decryption;
            }
        }

        return bestDecryption;
    }

    private double calculateFrequencyScore(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        int totalLetters = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
                totalLetters++;
            }
        }

        double score = 0.0;
        for (char letter : frequencies.keySet()) {
            double expectedFrequency = getExpectedFrequency(letter);
            double observedFrequency = (double) frequencies.get(letter) / totalLetters;
            score += Math.pow(expectedFrequency - observedFrequency, 2);
        }

        return score;
    }

    private double getExpectedFrequency(char letter) {
        return switch (Character.toUpperCase(letter)) {
            case 'E' -> 0.127;
            case 'T' -> 0.091;
            case 'A' -> 0.082;
            case 'O' -> 0.075;
            case 'I' -> 0.070;
            case 'N' -> 0.067;
            case 'S' -> 0.063;
            case 'H' -> 0.061;
            case 'R' -> 0.060;
            case 'D' -> 0.043;
            case 'L' -> 0.040;
            case 'C' -> 0.028;
            case 'U' -> 0.028;
            case 'M' -> 0.024;
            case 'W' -> 0.023;
            case 'F' -> 0.022;
            case 'G' -> 0.020;
            case 'Y' -> 0.019;
            case 'P' -> 0.019;
            case 'B' -> 0.015;
            case 'V' -> 0.010;
            case 'K' -> 0.008;
            case 'J' -> 0.002;
            case 'X' -> 0.001;
            case 'Q' -> 0.001;
            case 'Z' -> 0.001;
            default -> 0.0;
        };
    }
}
