package tests.string;

import org.junit.jupiter.api.Test;
import problems.string.OneEditAway;

import static org.junit.jupiter.api.Assertions.*;

class OneEditAwayTest {

    private OneEditAway oneEditAway;

    @Test
    void hugelyUnequalLengths() {
        oneEditAway = new OneEditAway();
        assertFalse(oneEditAway.areOneAway("m", "masdfasf"));
    }

    @Test
    void equalButDifferent() {
        oneEditAway = new OneEditAway();
        assertFalse(oneEditAway.areOneAway("asdf", "lkjh"));
    }

    @Test
    void gotOneWordSame() {
        oneEditAway = new OneEditAway();
        assertFalse(oneEditAway.areOneAway("car", "bat"));
    }

    @Test
    void oneAwayEqualLengths() {
        oneEditAway = new OneEditAway();
        assertTrue(oneEditAway.areOneAway("car", "cat"));
    }

    @Test
    void oneAwayUnequalLengths() {
        oneEditAway = new OneEditAway();
        assertTrue(oneEditAway.areOneAway("pup", "pump"));
    }

}