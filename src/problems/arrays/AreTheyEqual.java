package problems.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 27/05/2021 07:40
 *
 * Reverse to Make Equal
 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any
 * subarrays from array B any number of times.
 *
 * Signature
 * bool areTheyEqual(int[] arr_a, int[] arr_b)
 *
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 *
 * Output
 * Return true if B can be made equal to A, return false otherwise.
 *
 * Example
 * A = [1, 2, 3, 4]
 * B = [1, 4, 3, 2]
 * output = true
 * After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 */
public class AreTheyEqual {

    public boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length)
            return false;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a : array_a) {
            hm.merge(a, 1, Integer::sum);
        }
        for (int b : array_b) {
            if (!hm.containsKey(b) || hm.get(b) == 0)
                return false;
            hm.compute(b, (bInt, prev) -> prev - 1);
        }
        Map<Integer, Integer> res = hm.entrySet()
                .stream()
                .filter(map -> map.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return res.size() == 0;
    }

}
