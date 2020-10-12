package problems.sorting;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 12/10/20 23:46
 */
public class InsertionSort {

    public int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int v = a[i];
            int j = i;
            while (j >= 1 && a[j - 1] > v) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }
        return a;
    }

}
