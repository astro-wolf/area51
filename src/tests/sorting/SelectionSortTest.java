package tests.sorting;

import org.junit.jupiter.api.Test;
import problems.sorting.SelectionSort;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    private SelectionSort selectionSort;

    @Test
    void empty() {
        selectionSort = new SelectionSort();
        assertEquals(0, selectionSort.selectionSort(new int[]{}).length);
    }

    @Test
    void totallyInverted() {
        selectionSort = new SelectionSort();
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(b, selectionSort.selectionSort(a));
    }
}