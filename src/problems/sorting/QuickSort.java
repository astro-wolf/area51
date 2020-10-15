package problems.sorting;

import org.jetbrains.annotations.NotNull;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 15/10/20 23:13
 */
public class QuickSort {

    public int[] quickSort(int @NotNull [] a) {
        if (a.length > 2)
            quickSort(a, 0, a.length - 1);
        return a;
    }

    private void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = findPivot(a, left, right);
            quickSort(a, left, pivot - 1);
            quickSort(a, pivot + 1, right);
        }
    }

    private int findPivot(int[] a, int left, int right) {
        int item = a[left];
        int l = left, r = right;
        while (l < r) {
            while (l < a.length && a[l] <= item)
                l++;
            while (r >= 0 && a[r] > item)
                r--;
            if (l < r)
                swap(a, l, r);
        }
        a[left] = a[r];
        a[r] = item;
        return r;
    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

}
