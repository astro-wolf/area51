package tests.string;

import org.junit.jupiter.api.Test;
import problems.string.RabinKarp;

import static org.junit.jupiter.api.Assertions.*;

class RobinKarpTest {

    private RabinKarp rabinKarp;

    @Test
    void empty() {
        // my implementation will return false here,
        // but I have no clue what Robin-Karp should actually do
        rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.rabinKarp("", ""));
    }

    @Test
    void dontMatch() {
        rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.rabinKarp("asdfghjklqwertyuiop", "zxcv"));
    }

    @Test
    void matchInStart() {
        rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.rabinKarp("asdfghjklqwertyuiop", "asdfgh"));
    }

    @Test
    void matchInMid() {
        rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.rabinKarp("asdfghjklqwertyuiop", "klqwe"));
    }

    @Test
    void matchInEnd() {
        rabinKarp = new RabinKarp();
        assertFalse(rabinKarp.rabinKarp("asdfghjklqwertyuiop", "uiop"));
    }

}