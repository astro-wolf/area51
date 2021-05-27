package tests.arrays;

import org.junit.jupiter.api.Test;
import problems.arrays.AreTheyEqual;

import static org.junit.jupiter.api.Assertions.*;

class AreTheyEqualTest {

    private AreTheyEqual areTheyEqual;

    @Test
    void theyAre() {
        areTheyEqual = new AreTheyEqual();
        assertEquals(true, areTheyEqual.areTheyEqual(
                new int[]{1, 2, 3, 4},
                new int[]{1, 4, 3, 2}
        ));
    }

    @Test
    void theyArent() {
        areTheyEqual = new AreTheyEqual();
        assertEquals(false, areTheyEqual.areTheyEqual(
                new int[]{1, 2, 3, 4},
                new int[]{1, 4, 3, 3}
        ));
    }
}