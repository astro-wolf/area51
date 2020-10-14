package tests.sorting;

import org.junit.jupiter.api.Test;
import problems.sorting.HeapSort;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    private HeapSort heapSort;

    @Test
    void totallyInverted() {
        heapSort = new HeapSort();
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(b, heapSort.heapSort(a));
    }

}