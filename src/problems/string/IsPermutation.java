package problems.string;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 12/11/20 08:08
 *
 * Find out if one string is permutation of the other
 */
public class IsPermutation {

    public boolean isPerm(String s1, String s2) {
        if (s1 == null
                || s2 == null
                || s1.length() != s2.length())
            return false;
        int[] letters = new int[128];
        for (char c : s1.toCharArray()) {
            letters[c] += 1;
        }
        for (char c : s2.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

}
