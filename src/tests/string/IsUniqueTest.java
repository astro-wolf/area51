package tests.string;

import org.junit.jupiter.api.Test;
import problems.string.IsUnique;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {

    private IsUnique isUnique;


    @Test
    void emptyAndOneChar() {
        isUnique = new IsUnique();
        assertTrue(isUnique.isUnique(null));
        assertTrue(isUnique.isUnique(""));
        assertTrue(isUnique.isUnique("a"));
    }

    @Test
    void unique() {
        isUnique = new IsUnique();
        assertTrue(isUnique.isUnique("qwhobpx"));
    }

    @Test
    void notUnique() {
        isUnique = new IsUnique();
        assertFalse(isUnique.isUnique("zhz"));
    }

}