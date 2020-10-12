package tests.sorting;

import org.junit.jupiter.api.Test;
import problems.sorting.InsertionSort;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    private InsertionSort insertionSort;

    @Test
    void empty() {
        insertionSort = new InsertionSort();
        assertEquals(0, insertionSort.insertionSort(new int[]{}).length);
    }

    @Test
    void totallyInverted() {
        insertionSort = new InsertionSort();
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(b, insertionSort.insertionSort(a));
    }

}