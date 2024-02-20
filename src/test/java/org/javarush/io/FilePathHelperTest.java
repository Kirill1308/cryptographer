package org.javarush.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilePathHelperTest {

    @Test
    void hasBrackets_whenBracketsExist_true() {
        String filePathWithBrackets = "/path/to/file[name].txt";

        assertTrue(FilePathHelper.hasBrackets(filePathWithBrackets));
    }

    @Test
    void hasBrackets_whenBracketsDoNotExist_false() {
        String filePathWithoutBrackets = "/path/to/filename.txt";

        assertFalse(FilePathHelper.hasBrackets(filePathWithoutBrackets));
    }

    @Test
    void hasBrackets_whenFilepathIsEmpty() {
        String emptyFilepath = "";

        assertFalse(FilePathHelper.hasBrackets(emptyFilepath));
    }

    @Test
    void hasBrackets_whenBracketsAreIncomplete() {
        String incompleteBracketFilepath = "/path/to/file[name.txt";

        assertFalse(FilePathHelper.hasBrackets(incompleteBracketFilepath));
    }

    @Test
    void generateTaggedFilePath_pathHasBrackets_true() {
        String filepath = "directory/[filename].txt";
        String tag = "tagged";
        String expected = "directory/tagged.txt";

        String actual = FilePathHelper.generateTaggedFilePath(filepath, tag);

        assertEquals(expected, actual);
    }

    @Test
    void generateTaggedFilePath_pathNoBrackets_true() {
        String filepath = "directory/filename.txt";
        String tag = "tagged";
        String expected = "directory/filename.txt" + tag;

        String actual = FilePathHelper.generateTaggedFilePath(filepath, tag);

        assertEquals(expected, actual);
    }
}
