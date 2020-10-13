package problems.sorting;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 13/10/20 23:49
 */
public class MergeSort {

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2)
            return arr;
        return divideAndConquer(arr, 0, arr.length - 1);
    }

    private int[] divideAndConquer(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            divideAndConquer(arr, left, mid);
            divideAndConquer(arr, mid + 1, right);
            merge(arr, left, right);
        }
        return arr;
    }

    private void merge(int[] arr, int left, int right) {
        int size = (right - left) + 1;
        int[] temp = new int[size];
        int mid = (left + right) /  2;
        int rPos = mid + 1;
        int tempPos = 0;
        while(left <= mid && rPos <= right) {
            if (arr[left] < arr[rPos]) {
                temp[tempPos++] = arr[left++];
            } else {
                temp[tempPos++] = arr[rPos++];
            }
        }
        while (left <= mid)
            temp[tempPos++] = arr[left++];
        while (rPos <= right)
            temp[tempPos++] = arr[rPos++];
        for (int i = size - 1; i >= 0; i--) {
            arr[right--] = temp[i];
        }
    }

}
