package tests.string;

import org.junit.jupiter.api.Test;
import problems.string.KMP;

import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    private KMP kmp;

    @Test
    void simpleExist() {
        kmp = new KMP();
        assertEquals(0, kmp.exist("ababababa", "aba"));
    }

    @Test
    void existInTheEnd() {
        kmp = new KMP();
        assertEquals(8, kmp.exist("ababababaa", "aa"));
    }

}