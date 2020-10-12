package tests.sorting;

import org.junit.jupiter.api.Test;
import problems.sorting.BubbleSort;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private BubbleSort bubbleSort;

    @Test
    void empty() {
        bubbleSort = new BubbleSort();
        assertEquals(0, bubbleSort.bubbleSort(new int[]{}).length);
    }

    @Test
    void totallyInverted() {
        bubbleSort = new BubbleSort();
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(b, bubbleSort.bubbleSort(a));
    }

}