package org.javarush.cipher.caesar.command;

import lombok.extern.log4j.Log4j2;
import org.javarush.cipher.ActionCommand;
import org.javarush.io.FilePathHelper;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class HackCaesarCommand extends ActionCommand {
    public HackCaesarCommand(String filepath) {
        super(filepath, 0);
    }

    @Override
    protected String processContent(String content) {
        System.out.println("Hacking complete!");
        return hack(content);
    }

    @Override
    protected String getDestFilePath(String filepath) {
        log.info("Generating hacked filepath...");
        final String HACKED_TAG = "[HACKED]";

        return FilePathHelper.generateTaggedFilePath(filepath, HACKED_TAG);
    }

    private String hack(String encryptedText) {
        log.info("Hacking...");

        String bestDecryption = "";
        double bestScore = Double.MAX_VALUE;

        for (int shift = 1; shift <= 25; shift++) {
            String decryption = DecryptCaesarCommand.decrypt(encryptedText, shift);
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
        for (Map.Entry<Character, Integer> letter : frequencies.entrySet()) {
            double expectedFrequency = getExpectedFrequency(letter.getKey());
            double observedFrequency = (double) frequencies.get(letter.getKey()) / totalLetters;
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
