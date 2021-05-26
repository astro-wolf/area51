package tests.string;

import org.junit.jupiter.api.Test;
import problems.string.RotationalCipher;

import static org.junit.jupiter.api.Assertions.*;

class RotationalCipherTest {

    private RotationalCipher rc;

    @Test
    void general() {
        rc = new RotationalCipher();
        assertEquals("stuvRPQrpq-999.@", rc.rotationalCipher("abcdZXYzxy-999.@", 200));
    }

}