package tests;

import org.junit.jupiter.api.Test;
import problems.heap.PairHeap;

import static org.junit.jupiter.api.Assertions.*;

class PairHeapTest {

    private PairHeap pairHeap;

    @Test
    void empty() {
        pairHeap = new PairHeap(10);
        assertNull(pairHeap.getMin());
    }

    @Test
    void add() {
        pairHeap = new PairHeap(5);
        pairHeap.add(1, 9);
        pairHeap.add(4, 5);
        pairHeap.add(434, 12);
        assertEquals(4, pairHeap.getMin().index);
        assertEquals(1, pairHeap.getMin().index);
    }

    @Test
    void update() {
        pairHeap = new PairHeap(5);
        pairHeap.add(1, 9);
        pairHeap.add(4, 5);
        pairHeap.add(434, 12);
        pairHeap.update(434, 1);
        assertEquals(434, pairHeap.getMin().index);
        assertEquals(4, pairHeap.getMin().index);
    }

}