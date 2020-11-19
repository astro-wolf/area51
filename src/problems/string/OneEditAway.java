package problems.string;

/**
 * @author Vishwas
 * @version Revision 1.0, created at 19/11/20 06:54
 *
 * Check if two strings are one edit away from each other.
 * One edit away means, there should be a difference of one character between them
 */
public class OneEditAway {

    public boolean areOneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;
        boolean didUnmatch = false;
        String n, m;
        if (s1.length() > s2.length()) {
            n = s1;
            m = s2;
        } else {
            n = s2;
            m = s1;
        }
        int i = 0, j = 0;
        while (i < n.length() && j < m.length()) {
            if (n.charAt(i) != m.charAt(j)) {
                if (didUnmatch) {
                    return false;
                }
                didUnmatch = true;
                if (n.length() == m.length()) {
                    j++;
                }
            } else {
                j++;
            }
            i++;
        }
        return true;
    }

}
