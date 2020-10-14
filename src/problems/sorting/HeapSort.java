package problems.sorting;

import org.jetbrains.annotations.NotNull;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 14/10/20 23:55
 */
public class HeapSort {

    int count = 0;

    public int[] heapSort(int @NotNull [] a) {
        this.count = a.length;
        a = heapify(a);
        for (int i = count - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[count - 1];
            a[count - 1] =  temp;
            count--;
            percolateDown(a, 0);
        }
        count = a.length;
        return a;
    }

    private int[] heapify(int[] a) {
        for(int i = (count / 2) - 1; i >= 0; i--) {
            percolateDown(a, i);
        }
        return a;
    }

    private void percolateDown(int[] a, int pos) {
        int l = pos * 2 + 1;
        int r = pos * 2 + 2;
        int n = count;
        int max = pos;
        if (l < n && a[l] >  a[pos])
            max = l;
        if (r < n && a[r] > a[max])
            max = r;
        if (max != pos) {
            int temp = a[pos];
            a[pos] = a[max];
            a[max] = temp;
            percolateDown(a, max);
        }
    }

}
