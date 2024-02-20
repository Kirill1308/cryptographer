package org.javarush.io;

public final class FilePathHelper {
    private FilePathHelper() {
    }

    public static boolean hasBrackets(String filepath) {
        int startBracketIndex = filepath.indexOf('[');
        int endBracketIndex = filepath.lastIndexOf(']');

        return startBracketIndex != -1 && endBracketIndex != -1;
    }

    public static String generateTaggedFilePath(String filepath, String tag) {
        if (hasBrackets(filepath)) {
            int startBracketIndex = filepath.indexOf('[');
            int endBracketIndex = filepath.lastIndexOf(']');

            String preBracketContent = filepath.substring(0, startBracketIndex);
            String postBracketContent = filepath.substring(endBracketIndex + 1);

            return preBracketContent + tag + postBracketContent;
        }

        return filepath + tag;
    }
}
