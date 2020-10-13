package tests.sorting;

import org.junit.jupiter.api.Test;
import problems.sorting.InsertionSort;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private MergeSort mergeSort;

    @Test
    void empty() {
        mergeSort = new MergeSort();
        assertEquals(0, mergeSort.mergeSort(new int[]{}).length);
    }

    @Test
    void totallyInverted() {
        mergeSort = new MergeSort();
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(b, mergeSort.mergeSort(a));
    }

}