package problems.sorting;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 12/10/20 23:41
 */
public class SelectionSort {

    public int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = min + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return a;
    }

}
