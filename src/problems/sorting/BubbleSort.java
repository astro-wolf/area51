package problems.sorting;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 12/10/20 23:11
 *
 * <sarcasm>Implementation of world's greatest and most efficient algorithm to check
 * whether list is already  sorted or not</sarcasm>
 */
public class BubbleSort {

    public int[] bubbleSort(int[] a) {
        boolean swapped = true;
        int temp;
        for (int i = a.length - 1; i >= 0 && swapped; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
        }
        return a;
    }

}
