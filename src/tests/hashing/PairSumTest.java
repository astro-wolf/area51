package tests.hashing;

import org.junit.jupiter.api.Test;
import problems.hashing.PairSum;

import static org.junit.jupiter.api.Assertions.*;

class PairSumTest {

    private PairSum pairSum;

    @Test
    void unique() {
        pairSum = new PairSum();
        assertEquals(2, pairSum.numberOfWays(new int[]{1, 2, 3, 4}, 5));
    }

    @Test
    void dupes() {
        pairSum = new PairSum();
        assertEquals(4, pairSum.numberOfWays(new int[]{1, 5, 3, 3, 3}, 6));
    }

}