package tests.string;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import problems.string.IsPermutation;

import static org.junit.jupiter.api.Assertions.*;

class IsPermutationTest {

    private IsPermutation isPermutation;

    @Test
    void nullStrings() {
        isPermutation = new IsPermutation();
        assertFalse(isPermutation.isPerm(null, null));
    }

    @Test
    void unequalLengths() {
        isPermutation = new IsPermutation();
        assertFalse(isPermutation.isPerm("asdf", "h"));
    }

    @Test
    void permStrings() {
        isPermutation = new IsPermutation();
        assertTrue(isPermutation.isPerm("dog", "god"));
    }

    @Test
    void nonPermStrings() {
        isPermutation = new IsPermutation();
        assertFalse(isPermutation.isPerm("car", "cab"));
    }

}