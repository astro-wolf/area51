package tests.sorting;

import org.junit.jupiter.api.Test;
import problems.sorting.QuickSort;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private QuickSort quickSort;

    @Test
    void totallyInverted() {
        quickSort = new QuickSort();
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(b, quickSort.quickSort(a));
    }

}