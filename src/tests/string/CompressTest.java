package tests.string;

import org.junit.jupiter.api.Test;
import problems.string.Compress;

import static org.junit.jupiter.api.Assertions.*;

class CompressTest {

    Compress compress;

    @Test
    void empty() {
        compress = new Compress();
        assertEquals("", compress.compress(""));
    }

    @Test
    void returnOriginal() {
        compress = new Compress();
        assertEquals("abcd", compress.compress("abcd"));
    }

    @Test
    void returnCompressed() {
        compress = new Compress();
        assertEquals("a2b1c5a3", compress.compress("aabcccccaaa"));
    }

}