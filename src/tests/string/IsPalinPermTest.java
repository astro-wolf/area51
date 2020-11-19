package tests.string;

import org.junit.jupiter.api.Test;
import problems.string.IsPalinPerm;

import static org.junit.jupiter.api.Assertions.*;

class IsPalinPermTest {

    private IsPalinPerm isPalinPerm;

    @Test
    void empty() {
        isPalinPerm = new IsPalinPerm();
        assertTrue(isPalinPerm.isPalinPer(""));
    }

    @Test
    void shouldBeTrue() {
        isPalinPerm = new IsPalinPerm();
        assertTrue(isPalinPerm.isPalinPer("Tact Cao"));
    }

    @Test
    void shouldBeFalse() {
        isPalinPerm = new IsPalinPerm();
        assertFalse(isPalinPerm.isPalinPer("ABC def"));
    }

}